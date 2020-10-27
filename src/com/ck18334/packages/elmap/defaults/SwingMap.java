package com.chek.src.com.ck18334.packages.elmap.defaults;

import com.chek.src.com.ck18334.packages.elmap.ElementMap;

import javax.swing.*;

public class SwingMap extends ElementMap {
    public SwingMap(JFrame frame) {
        super("gui");
        extend("panel", false, "gui");
        extend("button", false, "gui");
        extend("combo", false, "gui");
        extend("table", false, "gui");
        extend("field", false, "gui");
        extend("scroll", false, "gui");
        extend("controller", false, "gui");
        extend("tab", false, "gui");
        put("frame", frame, "gui");
    }
}
