package it.thinkopen.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

    public static Connection getConnection() {
        //STEP 1: Register JDBC driver
        Connection connection = null;

        try {
            Class.forName(Config.getConfig().getProperty("jdbc_driver"));

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");

            connection = DriverManager.getConnection(Config.getConfig().getProperty("db_url"),
                    Config.getConfig().getProperty("user"),
                    Config.getConfig().getProperty("password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }

}
