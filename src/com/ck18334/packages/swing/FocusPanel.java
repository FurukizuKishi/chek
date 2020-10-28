package com.chek.src.com.ck18334.packages.swing;

import com.chek.src.com.ck18334.methods.drawMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FocusPanel extends JPanel {
    public FocusPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    requestFocus();
                }
            }
        });
    }

    public void drawFocusBorder(Graphics g, Color c) {
        if (hasFocus()) {
            drawMethods.drawBorder(g, this, 4, c, drawMethods.border.INSIDE);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFocusBorder(g, Color.CYAN);
        repaint();
    }
}
