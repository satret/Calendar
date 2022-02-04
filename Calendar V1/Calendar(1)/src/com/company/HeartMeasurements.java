package com.company;

import com.company.SQLconnect.DatabaseHandler;

import java.sql.SQLException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeartMeasurements extends JFrame {
    //Cоздаем кнопки и объекты
    private JButton button = new JButton("Ввод");
    private JTextField input = new JTextField("",5);
    private JLabel label = new JLabel("Введите пульс");
    private int pulse;
    private String timeStamp;

    public HeartMeasurements(){
        super("Пульс в течение дня");
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

            String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            Example.k++;
            String message = "";
            String message1="" + Example.k + ")";
            message +=  Example.str1 + message1 + input.getText() + " измерено в " + timeStamp + "\n";
            Example.str1 = message;

            //преобразование ввода в число
            int pulsein = ImbaMethods.convertstringtoint(input.getText(), pulse);

            //вызов метода ввода в БД
            try {
                dbHandler.addcolomnspheartrhythm(pulsein, timeStamp);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            //чтение с дазы данных
            try {
                dbHandler.readingdatapulse();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, Example.datastr1 , "Замеры пульса за все время", JOptionPane.PLAIN_MESSAGE);
        }
    }


}
















