package com.company.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import com.company.controller.GameManager;
import com.company.model.Texture;


public class GameFrame extends JFrame {

    /**
     * Objects, Variables, Components, ...
     */
    private static final int GAME_HEIGHT = getScreenHeight();    // 720p game resolution
    private static final int GAME_WIDTH = getScreenWidth();     // wide aspect ratio (16/9)

    private BufferStrategy bufferStrategy;

    /**
     * Object Constructor
     *
     * @param title JFrame title
     */
    public GameFrame(String title) {

        // Initialize default properties
        super(title);

        setResizable(false);                                     // Set resizable
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);            // Go full screen
        this.setUndecorated(true);                               // Remove title bar
        this.setBackground(Color.WHITE);                         // Set background color
    }

    /**
     * This method creates a BufferStrategy for the rendering
     */
    public void initBufferStrategy() {
        createBufferStrategy(5);
        bufferStrategy = getBufferStrategy();
    }

    /**
     * Game rendering with triple-buffering using BufferStrategy.
     *
     * @param state GameState object
     */
    public void render(GameManager state) throws IOException {
        // Render single frame
        do {
            do {
                // Get new Graphics2D to make sure the strategy is validated
                Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
                try {
                    doRendering(graphics, state);
                } finally {
                    graphics.dispose();    // Dispose the graphics
                }
                // Repeat the rendering if the drawing buffer contents were restored
            } while (bufferStrategy.contentsRestored());

            // Display the buffer
            bufferStrategy.show();

            // Force system to draw
            Toolkit.getDefaultToolkit().sync();

        } while (bufferStrategy.contentsLost());
    }

    /**
     * Rendering all game elements based on the game state.
     *
     * @param g2d     Graphics2D context
     * @param manager GameState object
     */
    private void doRendering(Graphics2D g2d, GameManager manager) {

        // Draw background
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getScreenWidth(), getScreenHeight());

        // Draw background

        // Draw game title (Background)
        g2d.setColor(Color.BLACK);
        g2d.setFont(g2d.getFont().deriveFont(Font.BOLD).deriveFont(24f));
        g2d.drawString(this.getTitle(), (getScreenWidth() - getStringWidth(g2d, this.getTitle())) / 2, 40);

        // Draw description
        String desc = "Describe something";
        g2d.setColor(Color.BLACK);
        g2d.setFont(g2d.getFont().deriveFont(Font.BOLD).deriveFont(24f));
        g2d.drawString(desc, (getScreenWidth() - getStringWidth(g2d, desc)) / 2, 100);

        // Draw Jump-Scare
        for (Texture texture : manager.getTextures()) {
            texture.draw(g2d);
        }
    }

    /**
     * Calculates the string width in pixels
     *
     * @param g2d Graphics2D
     * @param string string
     * @return Width
     */
    private int getStringWidth(Graphics2D g2d, String string) {
        return g2d.getFontMetrics().stringWidth(string);
    }

    /**
     * Get screen width
     *
     * @return width
     */
    private static int getScreenWidth() {
        return (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    }

    /**
     * Get screen height
     *
     * @return height
     */
    private static int getScreenHeight() {
        return (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    }

    /**
     * Get game height
     *
     * @return height
     */
    public static int getGAME_HEIGHT() {
        return GAME_HEIGHT;
    }

    /**
     * Get game width
     *
     * @return height
     */
    public static int getGAME_WIDTH() {
        return GAME_WIDTH;
    }
}
