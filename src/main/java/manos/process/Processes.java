package manos.process;

import com.github.britooo.looca.api.core.Looca;
import java.util.Locale;
import manos.connection.database.DatabaseConfig;

public class Processes {

    private Looca looca;
    private DatabaseConfig connection;

    public Processes() {
        this.looca = new Looca();
        this.connection = new DatabaseConfig();
    }

    public void getManosProcess() {

    }

    public void getProcess() {
        System.out.println(looca.getGrupoDeProcessos().getProcessos().get(0));
    }

    public void insertData() {
        try {

//            this.getData();
//            String updateQuery = String.format(Locale.US,
//                    "INSERT INTO dynamicHardware (cpu) "
//                    + "VALUES (%.2f, %.2f, %d)",
//                    1
//            );
//            connection.getConnection().update(updateQuery);
            System.out.println(this.toString());

            Thread.sleep(5000);
            this.insertData();

        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return "";
    }
}
