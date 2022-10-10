/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manos.connection.database;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author pedro
 */
public class DatabaseConfig {

    private JdbcTemplate connection;

    public DatabaseConfig() {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource​.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        dataSource​.setUrl("jdbc:sqlserver://svr-manosecurity.database.windows.net:1433;"
                + "database=db-azure-manosecurity;encryp\n"
                + "t=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");

        dataSource​.setUsername("admin-manosecurity");

        dataSource​.setPassword("#Gfgrupo6");

        this.connection = new JdbcTemplate(dataSource);

    }

    // GETTER
    public JdbcTemplate getConnection() {

        return connection;

    }
}
