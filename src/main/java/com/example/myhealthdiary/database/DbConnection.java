package com.example.myhealthdiary.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DbConnection {

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://tai.db.elephantsql.com:5432/ylcowkmm", "ylcowkmm", "XXIBDHSk3drvXjek2feTkTkMXeWBTUNf");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
