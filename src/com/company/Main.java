package com.company;

import com.company.controller.GameLoop;
import com.company.controller.GameManager;
import com.company.view.GameFrame;

import javax.swing.*;

public class Main {

    /**
     * Objects, Variables, Components, ...
     */
    private static GameFrame frame;
    private static GameManager manager;

    public static void main(String[] args) {

        frame = new GameFrame("<Place Holder> Game");
        try {
            manager = new GameManager();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        frame.setLocationRelativeTo(null);                            // put frame at center of screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.initBufferStrategy();

        // Create and execute the game-loop
        GameLoop game = new GameLoop(frame, manager);
        game.init();
        ThreadPool.execute(game);
    }
}
