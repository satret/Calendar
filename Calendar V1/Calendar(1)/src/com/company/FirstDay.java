package com.company;

import com.company.SQLconnect.DatabaseHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FirstDay extends JFrame {
    //Cоздаем кнопки
    private JButton button = new JButton("Заполнить расписание");
    private JButton button1 = new JButton("Посмотреть расписание");
    private JButton button2 = new JButton("Замеры сердца");
    private JButton closeButton = new JButton("Вернуться назад");

    DatabaseHandler dbHandler = new DatabaseHandler();


    public FirstDay(){
        super("Первый день");
        this.setBounds(200, 200, 1000, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 3, 4, 2));
        //Расставляем кнопки по местам
        ButtonGroup group = new ButtonGroup();
        button.addActionListener(new ButtonEventListener ());
        button1.addActionListener(new ButtonEventListener1 ());
        button2.addActionListener(new ButtonEventListener2 ());
        closeButton.addActionListener(new ButtonEventListener3 ());
        container.add(button);
        container.add(button1);
        container.add(button2);
        container.add(closeButton);
    }

    class ButtonEventListener implements ActionListener {//вызов класса расписания
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Schedule app = new Schedule();
            app.setVisible(true);
        }
    }

    class ButtonEventListener1 implements ActionListener {//вывод глобальной строчной переменной
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            SelectDay app = new SelectDay();
            app.setVisible(true);
        }
    }

    class ButtonEventListener2 implements ActionListener {//вызов класса измерения пульса
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            HeartMeasurements app = new HeartMeasurements();
            app.setVisible(true);
        }
    }
    class ButtonEventListener3 implements ActionListener {//вызов класса измерения пульса
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Calendar app = new Calendar();
            app.setVisible(true);
        }
    }
}