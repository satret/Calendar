package com.company;

import com.company.SQLconnect.DatabaseHandler;
import javafx.scene.text.FontWeight;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class Schedule extends JFrame {
    //Создаем кнопки и объекты
    private JButton button = new JButton("Ввод");
    private JButton closeButton = new JButton("Вернуться назад");
    private JButton statusButton = new JButton("Поменять статус");
    private JTextField inputplan = new JTextField("",5);
    private JTextField inputdate = new JTextField("",5);
    private JTextField inputtime = new JTextField("",5);
    private JTextField inputstatus = new JTextField("",5);
    private JLabel label = new JLabel("Введите сегодняшние цели");
    public Schedule(){
        super("Рассписание");
        this.setBounds(200, 200, 1000, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Добавление "переменных" в окно
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(8, 1, 2, 4));
        container.add(label);
        container.add(inputplan);
        container.add(inputdate);
        container.add(inputtime);
        container.add(inputstatus);

        //Font font = Font.font("Courier New", FontWeight.BOLD, 36);

        //button.setFont(font);

        //button.setFont(font);
        //Добавление кнопок в окно
        ButtonGroup group = new ButtonGroup();
        button.addActionListener(new ButtonEventListener ());
        closeButton.addActionListener(new ButtonEventListener2 ());
        statusButton.addActionListener(new ButtonEventListener3());
        container.add(button);
        container.add(statusButton);
        container.add(closeButton);
    }

    DatabaseHandler dbHandler = new DatabaseHandler();
    class ButtonEventListener implements ActionListener{//вывод текста в другое окно
        public void actionPerformed(ActionEvent e){
            try {
                dbHandler.addcolomnsplan(inputplan.getText(), inputdate.getText(), inputtime.getText()+":00");
                Example.missdate=0;
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Введите правильную дату", "Output", JOptionPane.PLAIN_MESSAGE);
                Example.missdate=1;
            }
            if(Example.missdate == 0) {
                JOptionPane.showMessageDialog(null, "Успешно загружено", "Output", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    class ButtonEventListener2 implements ActionListener {//вызов класса измерения пульса
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            FirstDay firstday = new FirstDay();
            firstday.setVisible(true);
        }
    }


    class ButtonEventListener3 implements ActionListener{//вывод текста в другое окно
        public void actionPerformed(ActionEvent e){
            try {
                dbHandler.readingdataandchangestatus(inputplan.getText(), inputdate.getText(), inputtime.getText()+":00", inputstatus.getText());
                Example.missdate=0;
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Введите правильную дату", "Output", JOptionPane.PLAIN_MESSAGE);
                Example.missdate=1;
            }
            if(Example.missdate == 0) {
                JOptionPane.showMessageDialog(null, "Успешно загружено", "Output", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }



}
