package com.company;

import com.company.SQLconnect.DatabaseHandler;

import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDay extends JFrame {
    //Cоздаем кнопки и объекты
    private JButton button = new JButton("Ввод");
    private JTextField input = new JTextField("",5);
    private JLabel label = new JLabel("Выберите день (пишите дату в формате (ГГГГ-ММ-ДД))");

    public SelectDay(){
        super("Выбор дня");
        this.setBounds(200, 200, 500, 200);
        //Расставляем компоненты по местам
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);
        //Расставляем кнопки по местам
        ButtonGroup group = new ButtonGroup();
        button.addActionListener(new ButtonEventListener ());
        container.add(button);
    }

    DatabaseHandler dbHandler = new DatabaseHandler();
    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //вызов метода ввода в БД
            try {
                dbHandler.readingdataforselectdate(input.getText());
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, Example.selectdate, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }


}





