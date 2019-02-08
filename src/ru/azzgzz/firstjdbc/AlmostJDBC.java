package ru.azzgzz.firstjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AlmostJDBC {

    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/home/azamat/Документы/MyStudy/SQLiteBrowserTest";
            // crate a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to sqlite has been established.");

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        connect();
    }
}
