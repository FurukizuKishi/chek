package com.chek.src.com.ck18334.packages.swing;

import com.chek.src.com.ck18334.methods.drawMethods;

import javax.swing.*;
import java.awt.*;

public class ThickLine extends JLayeredPane {
    private Color colour = Color.WHITE;
    protected int width = 1;
    private int x1, y1, x2, y2;
    private JPanel panel;
    public ThickLine() {

    }
    public ThickLine(JPanel panel, int x1, int y1, int x2, int y2, int width) {
        setPanel(panel);
        updatePoints(x1, y1, x2, y2);
        setWidth(width);
    }
    public ThickLine(JPanel panel, int x1, int y1, int x2, int y2, int width, Color colour) {
        this(panel, x1, y1, x2, y2, width);
        setColour(colour);
    }

    public void setPanel(JPanel panel) {
        if (this.panel != null) {
            this.panel.remove(this);
        }
        if (panel != null) {
            setBounds(0, 0, panel.getWidth(), panel.getHeight());
            panel.add(this);
        }
        this.panel = panel;
    }

    public void updatePoints(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setWidth(int w) {
        width = w;
    }

    public void setColour(Color c) {
        colour = c;
    }

    public void paintComponent(Graphics g) {
        g.setColor(colour);
        drawMethods.drawThickLine(g, x1, y1, x2, y2, width);
        g.setColor(Color.WHITE);
    }
}
