package com.company;

import com.company.SQLconnect.DatabaseHandler;
import javafx.stage.Stage;

import java.sql.SQLException;

import static javafx.application.Application.launch;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.getDbConnection();

        TextApp app1 = new TextApp();
        Calendar app = new Calendar();
        app.setVisible(true);
//
    }
}
