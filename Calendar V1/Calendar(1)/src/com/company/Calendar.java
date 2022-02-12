package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.xml.soap.Text;

public class Calendar extends JFrame {
    private int counter = 0;
    //Cоздаем кнопки и объекты
    private JLabel tasks;
    private JButton buttonplus = new JButton("+");
    private JButton buttonday1 = new JButton("day1");
    private JButton buttonminus = new JButton("-");
    //Text text = new Text();

    public Calendar() {
        super("Calendar");
        //text.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        this.setBounds(200, 200, 1000, 400);
        //условие остановки программы
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setDefaultCloseOperation(HIDE_ON_CLOSE);
        //Cоздаем метку
        tasks = new JLabel("Tasks:" + counter);

        //Подготавливаем панель
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        //Расставляем компоненты по местам
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 4, 2, 4));
        container.add(tasks);

        //Расставляем кнопки по местам
        ButtonGroup group = new ButtonGroup();
        container.add(buttonplus);
        container.add(buttonday1);
        container.add(buttonminus);

        //вызов методов
        initListenersplus();
        initListenersminus();
        initListeners2();
    }

    public void initListenersplus() {
        buttonplus.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) {
                                       counter = counter + 1;   /* Добавляем одну ворону */
                                       updateCrowCounter(); /* Сообщение, что кол. ворон изм.*/
                                   }
                               }
        );
    }
    public void initListenersminus() {
        buttonminus.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) {
                                       counter = counter - 1;   /* Вычитаем одну ворону */
                                       updateCrowCounter(); /* Сообщение, что кол. ворон изм.*/
                                   }
                               }
        );
    }
    public void initListeners2() {
        buttonday1.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e) {
                                       setVisible(false);
                                       FirstDay firstday = new FirstDay();//Вызываем класс, который открывается при нажатии кнпки day1
                                       firstday.setVisible(true);
                                   }
                               }
        );
    }
    private void updateCrowCounter() {
        tasks.setText("Tasks:" + counter);
    }
}