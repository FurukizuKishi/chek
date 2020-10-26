package com.ck18334.methods;

import java.awt.*;

public class drawMethods {
    public static void drawWindow(Graphics g, int x, int y, int w, int h) {
        drawWindow(g, x, y, w, h, null);
    }
    public static void drawWindow(Graphics g, int x, int y, int w, int h, Color colour) {
        if (colour != null) {
            g.setColor(colour);
            g.fillRect(x, y, w, h);
        }
        g.setColor(Color.WHITE);
        g.drawRect( x + 1,  y + 1,  w - 3,  h - 3);
        g.drawRect( x + 3,  y + 3,  w - 7,  h - 7);
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
