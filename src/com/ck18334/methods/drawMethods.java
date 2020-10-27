package com.chek.src.com.ck18334.methods;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

public class drawMethods {
    public enum border {
        INSIDE, OUTSIDE
    }
    public static Color transColor(Color color, double alpha) {
        return transColor(color, (int) alpha * 255);
    }
    public static Color transColor(Color color, int alpha) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
    }
    public static void drawWindow(Graphics g, int x, int y, int w, int h) {
        drawWindow(g, x, y, w, h, null, null);
    }
    public static void drawWindow(Graphics g, int x, int y, int w, int h, Color colour, Color borderColour) {
        if (colour != null) {
            g.setColor(colour);
            g.fillRect(x, y, w, h);
        }
        if (borderColour != null) {
            g.setColor(borderColour);
        }
        else {
            g.setColor(Color.WHITE);
        }
        g.drawRect( x + 1,  y + 1,  w - 3,  h - 3);
        g.drawRect( x + 3,  y + 3,  w - 7,  h - 7);
    }

    public static void drawThickLine(Graphics g, int x1, int y1, int x2, int y2, int width) {
        int dist = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        Rectangle line = new Rectangle(x1, y1 - (width / 2), dist, width);
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(Math.atan2(y1 - y2, x1 - x2) + Math.PI, x1, y1);
        g2.draw(line);
        g2.fill(line);
    }

    public static void drawBorder(Graphics g, JComponent comp, int width, Color color, border dir) {
        switch (dir) {
            case INSIDE:
                for (int i = 0; i < width; i += 1) {
                    g.setColor(transColor(color, (double) (width - i) / width));
                    g.drawRect(comp.getX() + i, comp.getY() + i, comp.getWidth() - 1 - i, comp.getHeight() - 1 - i);
                }
                break;
            case OUTSIDE:
                for (int i = 0; i < width; i += 1) {
                    g.setColor(transColor(color, (double) (width - i) / width));
                    g.drawRect(comp.getX() - 1 - i, comp.getY() - 1 - i, comp.getWidth() + i, comp.getHeight() + i);
                }
                break;
        }
        g.setColor(Color.WHITE);
    }

    //Create the dimensions for a drawn value bar.
    public static int[] createValueBarDimensions(int barX, int barY, int barWidth, int barHeight, int border) {
        int fillX = barX + border;
        int fillY = barY + border;
        int fillWidth = barWidth - (border * 2);
        int fillHeight = barHeight - (border * 2);
        return new int[] {fillX, fillY, fillWidth, fillHeight};
    }
    //Create a rectangular value bar.
    public static void drawValueBarSquare(Graphics g, int value, int maxValue, Color barColour, Color backColour, int x, int y, int w, int h, int dir) {
        drawValueBarSquare(g, value, maxValue, barColour, backColour, null, x, y, w, h, dir, 0);
    }
    public static void drawValueBarSquare(Graphics g, int value, int maxValue, Color barColour, Color backColour, Color borderColour, int x, int y, int w, int h, int dir, int border) {
        int[] fill = createValueBarDimensions(x, y, w, h, border);
        if (borderColour != null) {
            g.setColor(borderColour);
            g.fillRect(x, y, w, h);
        }
        if (backColour != null) {
            g.setColor(backColour);
            g.fillRect(fill[0], fill[1], fill[2], fill[3]);
        }
        g.setColor(barColour);
        switch (dir) {
            case 90: g.fillRect(fill[0], fill[1], methods.integerDivision(value, maxValue, fill[2]), fill[3]); break;
            case 0: g.fillRect(fill[0], methods.integerDivision(maxValue - value, maxValue, fill[3]), fill[2], fill[3]); break;
            case 270: g.fillRect(methods.integerDivision(maxValue - value, maxValue, fill[2]), fill[1], fill[2], fill[3]); break;
            case 180: g.fillRect(fill[0], fill[1], fill[2], methods.integerDivision(maxValue - value, maxValue, fill[3])); break;
        }
    }
}
