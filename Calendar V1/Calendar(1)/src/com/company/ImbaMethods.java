package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class ImbaMethods {
    public static int convertstringtoint(String s, int a){
        try
        {
            // именно здесь String преобразуется в int
            a = Integer.parseInt(s.trim());
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return a;
    }
    public void createButton(String s){
        //JButton button = new JButton("Ввод");
        //ButtonGroup group = new ButtonGroup();
        //button.addActionListener(new createButton.ButtonEventListener());
        //container.add(button);
    }
}
