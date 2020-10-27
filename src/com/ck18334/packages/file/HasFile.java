package com.chek.src.com.ck18334.packages.file;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

public abstract class HasFile {
    String defaultFilePath;
    String defaultFileFolder;
    String file;

    public JFileChooser createFileChooser(String file, FileFilter filter) {
        defaultFilePath = file;
        defaultFileFolder = Paths.get(file).toAbsolutePath().toString();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setCurrentDirectory(new File(defaultFileFolder));
        return fileChooser;
    }

    public String getFileFromChooser(JFileChooser chooser, int returnVal) {
        //Process the results.
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String selectedFile = chooser.getSelectedFile().getPath();
            int lastSeparator = selectedFile.lastIndexOf("\\");
            if (selectedFile.substring(0, lastSeparator).equals(defaultFileFolder)) {
                this.file = selectedFile.substring(lastSeparator + 1);
            }
            return selectedFile;
        }
        return null;
    }
}
