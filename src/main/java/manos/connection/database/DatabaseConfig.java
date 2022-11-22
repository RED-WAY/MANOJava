package manos.connection.database;

import manos.log.LogLevel;
import manos.log.Logger;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseConfig {

    private JdbcTemplate connection;
    private JdbcTemplate connectionMySql;
    private BasicDataSource dataSource = new BasicDataSource();
    private BasicDataSource mySql = new BasicDataSource();

    public JdbcTemplate getMySqlConnection() {
        try {
            // MYSQL CONFIG
            mySql.setDriverClassName("com.mysql.cj.jdbc.Driver");

            mySql.setUrl("jdbc:mysql://localhost:3306/mano?useTimezone=true&"
                    + "serverTimezone=UTC&"
                    + "autoReconnect=true&"
                    + "useSSL=false");

            mySql.setUsername("root");

            mySql.setPassword("#Gf52455690865");
            this.connectionMySql = new JdbcTemplate(mySql);
            return this.connectionMySql;
        } catch (Exception ex) {
            System.out.println("fudeu");
        }
        return this.connectionMySql;
    }

    public JdbcTemplate getConnection() {
        try {
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            dataSource.setUrl("jdbc:sqlserver://svr-manosecurity.database.windows.net:1433;"
                    + "database=db-azure-manosecurity;encryp\n"
                    + "t=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");

            dataSource.setUsername("admin-manosecurity");

            dataSource.setPassword("#Gfgrupo6");
            this.connection = new JdbcTemplate(dataSource);
            return this.connection;
        } catch (Exception ex) {
            System.out.println("fudeu");
        }
        return this.connection;
    }

    public void closeConnection() {
        try {
            dataSource.close();
        } catch (Exception ex) {
        }
    }

    public void closeMySql() {
        try {
            mySql.close();
        } catch (Exception ex) {

        }

    }

}
