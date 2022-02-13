package com.company;

import com.company.SQLconnect.DatabaseHandler;
import com.mysql.cj.x.protobuf.MysqlxCursor;

import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDay extends JFrame {
    //Cоздаем кнопки и объекты
    private JButton button = new JButton("Ввод");
    private JButton closeButton = new JButton("Вернуться назад");
    private JTextField input = new JTextField("",5);
    private JLabel label = new JLabel("Выберите день (пишите дату в формате (ГГГГ-ММ-ДД))");

    public SelectDay(){
        super("Выбор дня");
        this.setBounds(200, 200, 1000, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Расставляем компоненты по местам
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 2, 2, 2));
        container.add(label);
        container.add(input);
        //Расставляем кнопки по местам
        ButtonGroup group = new ButtonGroup();
        button.addActionListener(new ButtonEventListener ());
        closeButton.addActionListener(new ButtonEventListener2 ());
        container.add(button);
        container.add(closeButton);
    }

    DatabaseHandler dbHandler = new DatabaseHandler();
    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //вызов метода ввода в БД
            try {
                dbHandler.readingdataandsort(input.getText());
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, Example.selectdate, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class ButtonEventListener2 implements ActionListener {//вызов класса измерения пульса
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            FirstDay firstday = new FirstDay();
            firstday.setVisible(true);
        }
    }

}





