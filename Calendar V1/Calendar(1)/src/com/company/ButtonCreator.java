package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.xml.soap.Text;

public class ButtonCreator extends JFrame {
    private int counter = 0;
    //Cоздаем кнопки и объекты
    private JButton buttonplus = new JButton();
    //Text text = new Text();

    public ButtonCreator(String str) {
        super("Calendar");
        //text.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        this.setBounds(200, 200, 1000, 400);
        buttonplus = new JButton();
        //условие остановки программы
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setDefaultCloseOperation(HIDE_ON_CLOSE);
        //Cоздаем метку

        //Подготавливаем панель
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        //Расставляем компоненты по местам
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(30, 4, 2, 4));

        int k=0;
        ButtonGroup group = new ButtonGroup();
        //Расставляем кнопки по местам
        while(k<10){
            JButton buttonplus = new JButton(str);
            container.add(buttonplus);
            k++;
        }






        //вызов методов
        initListenersplus();
    }

    public void initListenersplus() {
        buttonplus.addActionListener(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                             System.out.println("SAO");
                                         }
                                     }
        );
    }
}