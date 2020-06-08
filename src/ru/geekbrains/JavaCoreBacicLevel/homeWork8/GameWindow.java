package ru.geekbrains.JavaCoreBacicLevel.homeWork8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_POS_X = 500;
    static final int WINDOW_POS_Y = 250;
    static final int WINDOW_WIDTH = 450;
    static final int WINDOW_HEIGHT = 450;

    private SettingsWindow settingsWindow;
    private BattleMap battleMap;

    public GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TIC TAC TOE");

        settingsWindow = new SettingsWindow(this);
        battleMap = new BattleMap(this);
        add(battleMap, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1,2));

        JButton buttonStartNewGame = new JButton("Start New Game");
        buttonStartNewGame.setBackground(Color.CYAN);
        panel.add(buttonStartNewGame);

        JButton buttonExit = new JButton("Exit");
        buttonExit.setBackground(Color.PINK);
        panel.add(buttonExit);

        add(panel, BorderLayout.SOUTH);

        buttonExit.addActionListener(e->{
            System.exit(0);
        });

        buttonStartNewGame.addActionListener(e->{
            settingsWindow.setVisible(true);
        });

        setVisible(true);
    }

    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int dotsToWin){
        battleMap.startNewGame(gameMode, fieldSizeX, fieldSizeY, dotsToWin);
    }

}
