package manos.connection.database;

import manos.log.LogLevel;
import manos.log.Logger;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseConfig {

    private JdbcTemplate connection;
    private JdbcTemplate connectionMySql;

    public DatabaseConfig() {

        BasicDataSource dataSource = new BasicDataSource();
        BasicDataSource mySql = new BasicDataSource();

        try {
            // AZURE CONFIG
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            dataSource.setUrl("jdbc:sqlserver://svr-manosecurity.database.windows.net:1433;"
                    + "database=db-azure-manosecurity;encryp\n"
                    + "t=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");

            dataSource.setUsername("admin-manosecurity");

            dataSource.setPassword("#Gfgrupo6");

            // MYSQL CONFIG
            mySql.setDriverClassName("com.mysql.cj.jdbc.Driver");

            mySql.setUrl("jdbc:mysql://localhost:3306/mano");

            mySql.setUsername("root");

            mySql.setPassword("urubu200");

            this.connection = new JdbcTemplate(dataSource);
            this.connectionMySql = new JdbcTemplate(mySql);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.log("Erro ao conectar com o banco de dados", ex.getMessage(), LogLevel.ERROR);
        }
    }

    public JdbcTemplate getMySqlConnection() {
        return this.connectionMySql;
    }

    public JdbcTemplate getConnection() {
        return this.connection;
    }

}
