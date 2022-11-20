package manos.cli;

// JAVA
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

// CLASSES
import manos.machine.Validation;
import manos.machine.MachineConfig;
import manos.hardware.Constant;
import manos.hardware.Dynamic;
import manos.machine.Machine;
import manos.process.Processes;
import manos.update.database.UpdateDataBase;

public class View {

    // INITIALIZING INSTANCES...
    Validation validation = new Validation();
    MachineConfig updateMachine = new MachineConfig();

    Scanner sc;
    String token;

    Machine machine;

    Constant constant;
    Dynamic dynamic;
    Processes processes;

    public View() {
        sc = new Scanner(System.in);
    }

    public void setVisible(Boolean gui) {

    }

    public void startupApp() {
    UpdateDataBase update = new UpdateDataBase();
        new Thread(() -> {
             update.needUpdate();
        }).start();

        this.verifyLink();
    }

    // search machine on DB
    public void verifyLink() {

        try {

            this.machine = this.validation.isManoCodeValid();

            Boolean alreadyLinked = Objects.nonNull(machine);

            if (alreadyLinked) {

                this.constant = new Constant(this.machine.getIdMachine());
                this.startDataCapture();

            } else {

                getToken();
            }

        } catch (SQLException ex) {
            System.err.println("An error occurred in the database");
            ex.printStackTrace();
        }

    }

    public void getToken() {
        System.out.println("Digite o token:");
        token = sc.nextLine();

        readInputToken();
    }

    // connect machine to web entity
    public void readInputToken() {
        token = token.trim();

        if (!token.matches("[0-9]+")) {

            System.out.println("Token inválido. Apenas números são permitidos!");
            getToken();

        } else {

            this.linkMachine(token);
        }

    }

    public void linkMachine(String token) {
        try {

            // validate at DATABASE if there is a machine with the typed token
            this.updateMachine.linkMachine(token);
            this.machine = this.validation.isManoCodeValid();

            Boolean wasLinked = Objects.nonNull(machine);

            new Thread(() -> {

                if (wasLinked) {

                    this.constant = new Constant(this.machine.getIdMachine());
                    this.constant.insertData();

                    this.startDataCapture();

                } else {

                    System.out.println("Máquina já esta conectada ou ainda não foi criada no site!");
                    getToken();

                }

            }).start();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void startDataCapture() {
        new Thread(() -> {
            this.dynamic = new Dynamic(this.machine.getIdMachine(), this.machine.getMachineName());
            this.dynamic.insertData();
        }).start();
        new Thread(() -> {
            this.processes = new Processes(this.machine.getMachineName(), this.machine.getIdMachine(), this.machine.getOperationalSystem());
            this.processes.getManosProcesses();
            this.processes.matchProcesses();
        }).start();
    }
}
