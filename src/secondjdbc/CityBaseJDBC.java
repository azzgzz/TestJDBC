package secondjdbc;

import java.sql.*;

public class CityBaseJDBC {

    private static final String url = "jdbc:sqlite:/home/azamat/Документы/Java/JavaWorkspaces/eclipse-workspace/SQLiteBrowserTest";

    private static Connection connection = null;
    private static Statement statement = null;

    private static void connect() {

        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    private static Connection getConnection() {
//        if (connection == null) {
//            connect();
//        }
//        return connection;
//    }

    private static Statement getStatement() {
        if (statement == null) {
            connect();
        }
        return statement;
    }

    private static void closeConnection() {
        try {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Statement stmt = CityBaseJDBC.getStatement();
        ResultSet res = null;
        String query = "select * from city a join country as b on a.country_id = b.id";


        try {
            res = stmt.executeQuery(query);

            while (res.next()) {
                System.out.println(res.getString(2)
                        + " | " + res.getString(5)
                        + " | " + res.getString(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (res != null)
                    res.close();
                closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


}
