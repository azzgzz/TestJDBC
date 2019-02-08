package ru.azzgzz.firstjdbc;

import java.sql.*;

public class YoutubeJDBC {

    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;


        try {
            //Driver d = (Driver) Class.forName("org.sqlite.JDBC").newInstance();

            String url = "jdbc:sqlite:SQLiteCityDB";

            con = DriverManager.getConnection(url);

            String insertYork = "insert into city (name, country_id)" +
                    "values ('York', (select id from country where name = 'USA'))";

            String sql = "Select * " +
                    "from city a join country b " +
                    "on a.country_id = b.id";
            stmt = con.createStatement();

            //res =
            stmt.execute(insertYork);
            res = stmt.executeQuery(sql);

            while (res.next()) {
                System.out.println(res.getString("name") + " | " + res.getString(5)
                        + " | " + res.getString("continent"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (res != null)
                    res.close();
                if (stmt != null)
                    stmt.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }
}
