package ru.geekbrains.JavaCoreBacicLevel.homeWork8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_POS_X = GameWindow.WINDOW_POS_X + 50;
    private static final int WINDOW_POS_Y = GameWindow.WINDOW_POS_Y + 50;
    private static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH - 100;
    private static final int WINDOW_HEIGHT = 400;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    static final int MODE_H_VS_AI = 0;
    static final int MODE_H_VS_H = 1;
    static int mode;

    private GameWindow gameWindow;

    private JRadioButton radioButtonHvsAI = new JRadioButton("Player 1 vs Computer", true);
    private JRadioButton radioButtonHvsH = new JRadioButton("Player 1 vs Player 2");
    private ButtonGroup gameMode = new ButtonGroup();

    private JSlider sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
    private JSlider sliderDotsToWin = new JSlider(MIN_FIELD_SIZE,MIN_FIELD_SIZE,MIN_FIELD_SIZE);

    public SettingsWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("GAME SETTINGS");

        setLayout(new GridLayout(8,1));

        add(new JLabel("Select Mode Of Game"));
        add(radioButtonHvsAI);
        add(radioButtonHvsH);
        gameMode.add(radioButtonHvsAI);
        gameMode.add(radioButtonHvsH);

        add(new JLabel("Select Field Size"));
        sliderFieldSize.setMajorTickSpacing(1);
        sliderFieldSize.setPaintLabels(true);
        sliderFieldSize.setPaintTicks(true);
        add(sliderFieldSize);

        add(new JLabel("Select Dots To Win"));
        sliderDotsToWin.setMajorTickSpacing(1);
        sliderDotsToWin.setPaintLabels(true);
        sliderDotsToWin.setPaintTicks(true);
        add(sliderDotsToWin);

        sliderFieldSize.addChangeListener(e ->{
            sliderDotsToWin.setMaximum(sliderFieldSize.getValue());
        });

        JButton buttonStartTheGame = new JButton("Start The Game");
        buttonStartTheGame.setBackground(Color.CYAN);
        add(buttonStartTheGame);

        buttonStartTheGame.addActionListener(e ->{
            setVisible(false);

            if(radioButtonHvsAI.isSelected()){
                mode = MODE_H_VS_AI;
            } else{
                mode = MODE_H_VS_H;
            }

            int fieldSize = sliderFieldSize.getValue();
            int dotsToWin = sliderDotsToWin.getValue();

            Logic.SIZE = fieldSize;
            Logic.DOTS_TO_WIN = dotsToWin;
            Logic.initMap();
            Logic.gameFinished = false;

            gameWindow.startNewGame(mode, fieldSize, fieldSize, dotsToWin);

        } );

        setVisible(false);
    }
}
