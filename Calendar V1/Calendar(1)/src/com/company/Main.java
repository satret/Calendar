package com.company;

import com.company.SQLconnect.DatabaseHandler;

import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.getDbConnection();

        Calendar app = new Calendar();
        app.setVisible(true);
    }
}
