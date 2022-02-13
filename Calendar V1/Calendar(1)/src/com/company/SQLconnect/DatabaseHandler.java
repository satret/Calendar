package com.company.SQLconnect;

import com.company.ButtonCreator;
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
    public void addcolomnsplan(String plans, String date, String time)
            throws ClassNotFoundException, SQLException {
        try (Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPass);
             Statement statement = conn.createStatement()) {
            //statement.executeUpdate("drop table Books");
            //statement.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id));");
            String sql = "INSERT INTO Books (name, date, time, status) VALUES (?,?,?,?)";
            String status = "Запланировано";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, plans);
            stmt.setString(2, date);
            stmt.setString(3, time);
            stmt.setString(4, status);
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

//    public void readingdata() throws ClassNotFoundException, SQLException {
//        try {
//            Connection con = DriverManager.getConnection(connectionString, dbUser, dbPass);
//            Example.datastr="";
//            Example.dataconst=0;
//            try {
//                Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT * FROM Books");
//                while (rs.next()) {
//                    String str = rs.getString(2);
//                    String str2 = rs.getString(3);
//                    Example.dataconst++;
//                    String message = "";
//                    String message1="" + Example.dataconst + ")";
//                    message +=  Example.datastr + message1 + str + " " + "(" + str2 + ")" + "\n";
//                    Example.datastr = message;
//                }
//                rs.close();
//                stmt.close();
//            } finally {
//                con.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void readingdatapulse() throws ClassNotFoundException, SQLException {//Считывает данные из базы данных и выводит пульс(введенный пользователем) с датой измерения
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
    /*
//    public void readingdataforselectdate(String date) throws ClassNotFoundException, SQLException {//Читает данные из базы данных и выводит занятие и время выбранной пользователем даты
//        try {
//            Connection con = DriverManager.getConnection(connectionString, dbUser, dbPass);
//            Example.selectdate="";
//            Example.selectdateconst=0;
//            try {
//                Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT * FROM Books");
//                while (rs.next()) {
//                    String str = rs.getString(2);
//                    String str2 = rs.getString(3);
//                    String str3 = rs.getString(4);
//                    String str4 = rs.getString(5);
//                    if(date.equals(str2)) {
//                        Example.selectdateconst++;
//                        String message = "";
//                        String message1 = "" + Example.selectdateconst + ")";
//                        message += Example.selectdate + message1 +" " + str3 + " " + str +" "+ str4 + "\n";
//                        Example.selectdate = message;
//                    }
//                }
//                rs.close();
//                stmt.close();
//            } finally {
//                con.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }




    public void readingdataforcreatebutton() throws ClassNotFoundException, SQLException {//Читает данные из базы данных и выводит занятие и время выбранной пользователем даты
        try {
            Connection con = DriverManager.getConnection(connectionString, dbUser, dbPass);
            Example.selectdate = "";
            Example.selectdateconst = 0;
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Books");
                while (rs.next()) {
                    String str4 = rs.getString(5);
                    System.out.println("sao+\n");
                    //ButtonCreator app = new ButtonCreator(str4);
                    //app.setVisible(true);
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

     */

    public void readingdataandsort(String date) throws ClassNotFoundException, SQLException {//Читает данные из базы данных и выводит занятие и время выбранной пользователем даты
        try {
            Connection con = DriverManager.getConnection(connectionString, dbUser, dbPass);
            Example.selectdate = "";
            Example.selectdateconst = 0;
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM books WHERE id>0 ORDER BY time");
                while (rs.next()) {
                    String str = rs.getString(2);
                    String str1 = rs.getString(3);
                    String str2 = rs.getString(4);
                    String str3 = rs.getString(5);
                    if(date.equals(str1)) {
                        Example.selectdateconst++;
                        String message = "";
                        String message1 = "" + Example.selectdateconst + ")";
                        message += Example.selectdate + message1 +" " + str2 + " " + str +" "+ str3 + "\n";
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


    public void readingdataandchangestatus(String name, String date, String time, String status) throws ClassNotFoundException, SQLException {//Читает данные из базы данных и выводит занятие и время выбранной пользователем даты
        try {
            Connection con = DriverManager.getConnection(connectionString, dbUser, dbPass);
            Example.selectdate = "";
            Example.selectdateconst = 0;
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Books");
                while (rs.next()) {
                    String str = rs.getString(2);
                    String str1 = rs.getString(3);
                    String str2 = rs.getString(4);
                    String str3 = rs.getString(1);
                    if(name.equals(str) && date.equals(str1) && time.equals(str2)) {

                        String sql1 = "UPDATE books SET status = (?) WHERE id = (?)";
                        PreparedStatement stmt1 = con.prepareStatement(sql1);
                        stmt1.setString(1, status);
                        stmt1.setString(2, str3);
                        stmt1.executeUpdate();
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