package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class TextApp extends Application
{

    @Override
    public void start(Stage primaryStage)
    {

        final Text caption = new Text("Username or Password Error...!\n"
                + "Please Enter Correct Details...");
        caption.setFill(Color.BLACK);
        caption.setStyle("-fx-font: 24 arial;");

        Stage dialogStage = new Stage();
        dialogStage.initStyle(StageStyle.UTILITY);
        dialogStage.setScene(new Scene(VBoxBuilder.create().children(caption).alignment(Pos.CENTER)
                .padding(new Insets(15, 15, 15, 15)).build()));
        dialogStage.show();
    }
}