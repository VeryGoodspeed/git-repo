package com.praxis.standalone.runaways;

import java.sql.*;
import java.util.Properties;

/**
 * Created by administrativo on 23/06/15.
 */
public class DBUtility {

    private static final String userName = "PRAXIS";
    private static final String password = "s1h0w3b";
    private static final String dbms     = "siho";
    private static final String hostname = "192.168.6.199";

    private static Connection getConnection(){
        Connection connection = null;
        Properties connectionProps = new Properties();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@" + hostname + ":1521:siho", userName, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        System.out.println("Connected to database");
        return connection;
    }

    public static void getDataFromTableActividades(){

        Connection conn = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM ACTIVIDADES");
            while (rs.next()){
                System.out.println(" ||| ");
                System.out.print(rs.getString(1));
                System.out.println(" ||| ");
                System.out.print(rs.getString(2));
                System.out.println(" ||| ");
                System.out.print(rs.getString(3));
                System.out.println(" ||| ");
                System.out.print(rs.getString(4));
                System.out.println(" ||| ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                try {
                    conn.close();
                    stmt.close();
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
