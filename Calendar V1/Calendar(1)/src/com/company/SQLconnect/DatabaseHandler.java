package com.company.SQLconnect;

import com.company.Example;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;
    public void getDbConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPass)){
            System.out.println("Успешное подключение");
        }
    }
    public void addcolomnsplan(String plans, String date)
            throws ClassNotFoundException, SQLException {
        try (Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPass);
             Statement statement = conn.createStatement()) {
            //statement.executeUpdate("drop table Books");
            //statement.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id));");
            String sql = "INSERT INTO Books (name, date) VALUES (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, plans);
            stmt.setString(2, date);
            stmt.executeUpdate();
        }
    }
    public void addcolomnspheartrhythm(int a, String times) throws ClassNotFoundException, SQLException {
        try (Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPass);
             Statement statement = conn.createStatement()) {
            String sql = "INSERT INTO pulse (name, time) VALUES (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, a);
            stmt.setTime(2, Time.valueOf(times));
            stmt.executeUpdate();
        }
    }

    public void readingdata() throws ClassNotFoundException, SQLException {
        try {
            Connection con = DriverManager.getConnection(connectionString, dbUser, dbPass);
            Example.datastr="";
            Example.dataconst=0;
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Books");
                while (rs.next()) {
                    String str = rs.getString(2);
                    String str2 = rs.getString(3);
                    Example.dataconst++;
                    String message = "";
                    String message1="" + Example.dataconst + ")";
                    message +=  Example.datastr + message1 + str + " " + "(" + str2 + ")" + "\n";
                    Example.datastr = message;
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readingdatapulse() throws ClassNotFoundException, SQLException {
        try {
            Connection con = DriverManager.getConnection(connectionString, dbUser, dbPass);
            Example.datastr1="";
            Example.dataconst1=0;
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM pulse");
                while (rs.next()) {
                    String str = rs.getString(2);
                    String str2 = rs.getString(3);
                    Example.dataconst1++;
                    String message = "";
                    String message1="" + Example.dataconst1 + ")";
                    message +=  Example.datastr1 + message1 + str + " " + "(" + str2 + ")" + "\n";
                    Example.datastr1 = message;
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readingdataforselectdate(String date) throws ClassNotFoundException, SQLException {
        try {
            Connection con = DriverManager.getConnection(connectionString, dbUser, dbPass);
            Example.selectdate="";
            Example.selectdateconst=0;
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Books");
                while (rs.next()) {
                    String str = rs.getString(2);
                    String str2 = rs.getString(3);
                    if(date.equals(str2)) {
                        Example.selectdateconst++;
                        String message = "";
                        String message1 = "" + Example.selectdateconst + ")";
                        message += Example.selectdate + message1 + str + " " + "(" + str2 + ")" + "\n";
                        Example.selectdate = message;
                    }
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}