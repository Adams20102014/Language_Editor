/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.languageeditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JFileChooser;

/**
 *
 * @author s1407003
 */
public class Button_Listener implements ActionListener {

    private JFileChooser fileChooser;
    private final Language_UI lu;
    private Properties prop;
    private File file;
    private final Jt_Language jlang;
    private Add_Language al;

    public Button_Listener(Language_UI lu, Jt_Language jlang) {
        this.lu = lu;
        this.jlang = jlang;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        prop = new Properties();
        if (e.getActionCommand().equals("open")) {
            fileChooser = new JFileChooser();
            int state = fileChooser.showOpenDialog(lu);
            if (state == JFileChooser.APPROVE_OPTION) {
                try {
                    File dir = fileChooser.getCurrentDirectory();
                    String name = fileChooser.getSelectedFile().getName();
                    System.out.println(name);
                    file = new File(dir, name);
                    FileInputStream fis = new FileInputStream(file);
                    prop.loadFromXML(fis);
                    jlang.setProp(prop);
                    jlang.getCellData();
                    jlang.getJtLanguage();
                    fis.close();
                } catch (IOException ex) {
                }
            }
        } else if (e.getActionCommand().equals("save")) {
            fileChooser = new JFileChooser();
            int state = fileChooser.showSaveDialog(lu);
            if (state == JFileChooser.APPROVE_OPTION) {
                try {
                    file = fileChooser.getSelectedFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    jlang.getProp().storeToXML(fos, "注释");
                    fos.close();
                } catch (IOException ex) {
                }
            }
        } else if (e.getActionCommand().equals("remove")) {
            jlang.removeRow();
        } else if (e.getActionCommand().equals("add")) {
            al = new Add_Language(jlang);
            if (jlang.isSelected()) {
                al.initJdAdd();
                al.setJfKeyText(jlang.getKeyText());
                al.setJfValueText(jlang.getValueText());
            } else {
                al.initJdAdd();
            }
        }
    }

}
