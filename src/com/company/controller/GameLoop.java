package com.company.controller;

/**
 * Imports
 */
import com.company.view.GameFrame;

import java.io.IOException;

/**
 * GameLoop class
 * <p>This class calls all the rendering methods</p>
 *
 * @author Keivan Ipchi Hagh & Bardia Ardakanian
 * @version 0.1.0
 */
public class GameLoop implements Runnable {

    /**
     * Objects, Variables, Components, ...
     */
    public static final int FPS = 30;                // Must be over 24
    private final GameFrame canvas;                    // Game frame obj
    private final GameManager manager;                // Game manager obj

    /**
     * Object Constructor
     *
     * @param frame GameFrame object
     */
    public GameLoop(GameFrame frame, GameManager manager) {
        this.canvas = frame;
        this.manager = manager;
    }

    /**
     * This must be called before the game loop starts.
     */
    public void init() {
        canvas.addKeyListener(manager.getKeyListener());
    }

    /**
     * Overrides the run method in the thread
     */
    @Override
    public void run() {
        boolean gameOver = false;
        while (!gameOver) {
            try {
                long start = System.currentTimeMillis();

                // Update & render
                manager.update();
                canvas.render(manager);
                gameOver = manager.isGameOver();

                long delay = (1000 / FPS) - (System.currentTimeMillis() - start);
                if (delay > 0)
                    Thread.sleep(delay);
            } catch (InterruptedException | IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            canvas.render(manager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
