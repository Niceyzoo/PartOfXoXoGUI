package ru.geekbrains.PartOfXoXoGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//после долгих мучений:) для крестиков-ноликов у меня есть:
// окно (которое я хотела, что бы после нажатия старт расширялось под размер поля игры, но увы...)
// собственно кнопки и над ними строка состояния (хотела чтобы там отображался ход игры)
// т.к. в 4 домашке поле было массивом, то и тут я думала сделать также и вроде сделала,
// но дальше не знаю как к ним обращаться (добавить слушатель) и привязать к ним ходы игрока и компьютера
// в принципе у меня ступор как соединить код из 4го ДЗ и то, что написано тут...возможно нужен другой подход к самой визуализации?

public class PartOfXoXoGUI {
    public static JButton StartBtn;
    public static JFrame StartWindow;


    public static void main(String[] args) {
        StartGame();
    }

    private static void StartGame() {
        StartWindow = new JFrame("XOXO");
        StartWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StartBtn = new JButton("Start");
        StartWindow.add(StartBtn);

        StartWindow.pack();
        StartWindow.setMinimumSize(StartWindow.getSize());
        StartWindow.setVisible(true);

        StartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartWindow.setVisible(false);
                StartWindow.getContentPane().setSize(800, 400);
                StartBtn.setVisible(false);// скрыть кнопку
                JPanel topPanel = new JPanel();
                topPanel.setBackground(Color.gray);
                topPanel.add(new JLabel("Ваш ход"));
                topPanel.setSize(100, 50);
                StartWindow.add(topPanel, BorderLayout.NORTH); // добавляем панель на окно преклепенное на верху


                JPanel centerPanel = new JPanel();
                centerPanel.setBackground(Color.pink);
                centerPanel.setSize(400, 400);


                ButtonGroup myGroup = new ButtonGroup(); // объявили группу кнопок
                ArrayList<JButton> masBTN = new ArrayList<JButton>(); // объявили массив
                centerPanel.setLayout(new GridLayout(3, 3)); // установили размер сетки 3 на 3 для слоя центральной панели


                for (int i = 0; i < 9; i++) {
                    masBTN.add(new JButton());  // в массив добавляем перменную
                    myGroup.add(masBTN.get(i)); // в группу добвляем переменную массива
                    centerPanel.add(masBTN.get(i)); // на панель добавляем переменную массива
                }
                masBTN.get(0).setSelected(true);


                StartWindow.add(centerPanel, BorderLayout.CENTER);
                StartWindow.setVisible(true);
                StartWindow.validate();
                StartWindow.pack();


            }
        });
    }


}

