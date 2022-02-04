package com.company;

import com.company.SQLconnect.DatabaseHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class Schedule extends JFrame {
    //Создаем кнопки и объекты
    private JButton button = new JButton("Ввод");
    private JTextField inputplan = new JTextField("",5);
    private JTextField inputdate = new JTextField("",5);
    private JTextField input1 = new JTextField("",5);
    private JLabel label = new JLabel("Введите сегодняшние цели");
    public Schedule(){
        super("Рассписание");
        this.setBounds(200, 200, 500, 200);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Добавление "переменных" в окно
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(inputplan);
        container.add(inputdate);

        //Добавление кнопок в окно
        ButtonGroup group = new ButtonGroup();
        button.addActionListener(new ButtonEventListener ());
        container.add(button);
    }

    DatabaseHandler dbHandler = new DatabaseHandler();
    class ButtonEventListener implements ActionListener{//вывод текста в другое окно
        public void actionPerformed(ActionEvent e){
            try {
                dbHandler.addcolomnsplan(inputplan.getText(), inputdate.getText());
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
