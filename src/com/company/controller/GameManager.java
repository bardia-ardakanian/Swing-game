package com.company.controller;

import com.company.model.Texture;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;


public class GameManager {
    private boolean gameOver;

    // Objects
    private final ArrayList<Texture> textures;

    // Input stuff
    private boolean keyUP, keyDOWN, keyRIGHT, keyLEFT, keySPACE;   // Accepted key bindings
    private final KeyListener keyHandler;

    /**
     * Object constructor
     */
    public GameManager() {
        gameOver = false;

        // Objects
        textures = new ArrayList<>();
        // Generate random stuff
        initTexture();

        // Input stuff
        keyUP = false;
        keyDOWN = false;
        keyRIGHT = false;
        keyLEFT = false;
        keySPACE = false;

        keyHandler = new KeyHandler();
    }

    /**
     * Getter
     *
     * @return gameOver
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Getter
     *
     * @return textures
     */
    public ArrayList<Texture> getTextures() {
        return textures;
    }

    /**
     * Key Listener
     *
     * @return KeyListener
     */
    public KeyListener getKeyListener() {
        return keyHandler;
    }

    /**
     * The method updates the game state.
     * <p>Note that order of the drawing is important for both rendering speed and outfitting!</p>
     */
    public void update() {

        // Remove the disposed game objects
        disposalHandler();
    }

    private void initTexture() {
        Texture texture = new Texture(0, 0, 0, 0, null);
        texture.setIcon("rick");
        textures.add(texture);
    }

    /**
     * Checks if any of the game objects are to be disposed, and disposes them
     */
    private void disposalHandler() {

    }

    /**
     * The keyboard handler.
     */
    class KeyHandler extends KeyAdapter implements Serializable {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP -> keyUP = true;
                case KeyEvent.VK_DOWN -> keyDOWN = true;
                case KeyEvent.VK_LEFT -> keyLEFT = true;
                case KeyEvent.VK_RIGHT -> keyRIGHT = true;
                case KeyEvent.VK_SPACE -> keySPACE = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP -> keyUP = false;
                case KeyEvent.VK_DOWN -> keyDOWN = false;
                case KeyEvent.VK_LEFT -> keyLEFT = false;
                case KeyEvent.VK_RIGHT -> keyRIGHT = false;
                case KeyEvent.VK_SPACE -> keySPACE = false;
            }
        }
    }
}
