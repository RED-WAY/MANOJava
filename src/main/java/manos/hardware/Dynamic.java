package manos.hardware;

import com.github.britooo.looca.api.core.Looca;
import java.util.Locale;

import manos.connection.database.DatabaseConfig;
import manos.extern.Telegram;

public class Dynamic {

    private Double cpuUse;
    private Double ramUse;

    private Integer idMachine;
    private String machineName;

    private Looca looca;
    private DatabaseConfig connection;
    private Telegram telegram;

    public Dynamic(Integer idMachine, String machineName) {
        this.idMachine = idMachine;
        this.machineName = machineName;
        this.looca = new Looca();
        
        this.telegram = new Telegram();

        this.telegram.requestChatIds();
    }

    public void getData() {
        this.cpuUse = looca.getProcessador().getUso();
        this.ramUse = Double.valueOf((looca.getMemoria().getEmUso() * 100) / looca.getMemoria().getTotal());
    }

    public void insertData() throws InterruptedException {

        Boolean isLogged = true;
       

        try {
         this.connection = new DatabaseConfig();
            this.getData();

            String updateQuery = String.format(Locale.US,
                    "INSERT INTO dynamicHardware (cpu, ram, fkMachine) "
                    + "VALUES (%.2f, %.2f, %d)",
                    this.cpuUse,
                    this.ramUse,
                    this.idMachine
            );

            connection.getConnection().update(updateQuery);
            connection.closeConnection();
            System.out.println("CLOUD: " + this.toString());

            Thread.sleep(5000);
            this.insertData();

        } catch (InterruptedException ex) {

            isLogged = false;

            ex.printStackTrace();
            Thread.currentThread().interrupt();

        } catch (Exception ex) {

            isLogged = false;

            this.getData();

            String updateQuery = String.format(Locale.US,
                    "INSERT INTO dynamicHardware (cpu, ram, fkMachine) "
                    + "VALUES (%.2f, %.2f, %d)",
                    this.cpuUse,
                    this.ramUse,
                    this.idMachine
            );

            connection.getMySqlConnection().update(updateQuery);
            System.out.println("LOCAL: " + this.toString());

            connection.closeMySql();
            Thread.sleep(5000);
            this.insertData();

        } finally {

            if (isLogged) {
                if (this.cpuUse > 80) {
                    this.telegram.sendNotification("CPU: " + this.cpuUse.intValue() + "% - em PERIGO na máquina " + this.machineName);
                }

                if (this.ramUse > 80) {
                    this.telegram.sendNotification("RAM: " + this.ramUse.intValue() + "% - em PERIGO na máquina " + this.machineName);
                }

            }

           Thread.sleep(5000);
            this.insertData();

        }
    }

    @Override
    public String toString() {
        return "\n"
                + "CPU: " + this.cpuUse.intValue() + "%\n"
                + "RAM: " + this.ramUse.intValue() + "%\n\n";
    }
}
