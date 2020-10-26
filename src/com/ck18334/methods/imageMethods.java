package com.ck18334.methods;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class imageMethods {
    //Obtain a sprite from a path.
    public static BufferedImage getExternalImage(String spritePath) {
        File file = new File(spritePath);
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            //System.out.println(e);
            return null;
        }
    }

    //Code sourced from stack overflow users Suken Shah and Mr. Polywhirl - https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
    public static BufferedImage getScaledImage(BufferedImage srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
