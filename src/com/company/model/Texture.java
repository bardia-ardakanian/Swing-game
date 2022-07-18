package com.company.model;

import com.company.view.GameFrame;
import com.company.view.TextureReference;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

public class Texture {

    protected int x;
    protected int y;                     // Obstacle's X & Y Axis
    protected final int width, height;            // Obstacle's Width & height
    protected Color color;                        // Obstacle's Color
    private BufferedImage icon;                         // Care package's icon
    private double xScale = 1d, yScale = 1d;

    /**
     * Object Constructor
     *
     * @param x      X-Axis
     * @param y      Y-Axis
     * @param width  Width
     * @param height Height
     * @param color  Color
     */
    public Texture(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics2D g2d) {

        AffineTransform at = new AffineTransform();

        // Draw the texture
        center(getIcon().getWidth(), getIcon().getHeight());
        at.translate(this.x, this.y);                                                                     // Translate icon
        at.scale(this.xScale, this.yScale);                                                               // Scale icon
        g2d.drawImage(this.icon, at, null);
    }

    public void setIcon(String name) {
        try {
            this.icon = ImageIO.read(new File(TextureReference.getPath(name)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void center(double width, double height) {
        double canvasWidth = GameFrame.getGAME_WIDTH(), canvasHeight = GameFrame.getGAME_HEIGHT();

        this.x = (int) ((canvasWidth - width) / 2);
        this.y = (int) ((canvasHeight - height) / 2);
    }

    /**
     * Getter
     *
     * @return X-Axis
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter
     *
     * @return Y-Axis
     */
    public int getY() {
        return this.y;
    }

    /**
     * Getter
     *
     * @return Obj width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Getter
     *
     * @return Obj height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Getter
     *
     * @return Obj color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Getter
     *
     * @return Obj icon
     */
    public BufferedImage getIcon() {
        return icon;
    }

    /**
     * Getter
     *
     * @return Obj x-scale
     */
    public double getXScale() {
        return xScale;
    }

    /**
     * Getter
     *
     * @return Obj y-scale
     */
    public double getYScale() {
        return yScale;
    }
}
