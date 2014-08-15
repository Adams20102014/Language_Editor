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
import javax.swing.filechooser.FileFilter;

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
    private boolean isEnabled = false;
    private Button btn;
//    private String title;
    private boolean temp;

    public Button_Listener(Language_UI lu, Jt_Language jlang, Button btn) {
        this.lu = lu;
        this.jlang = jlang;
        this.btn = btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        prop = new Properties();
        if (e.getActionCommand().equals("Open")) {
            fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileFilter() {

                @Override
                public boolean accept(File file) {
                    return file.getName().endsWith(".xml");
                }

                @Override
                public String getDescription() {
                    return "Language Editor(*.xml)";
                }
            });
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
                    isEnabled = true;
                    btn.getEnabled(isEnabled);
                    fis.close();
                } catch (IOException ex) {
                }
            }
        } else if (e.getActionCommand().equals("Save")) {
            fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileFilter() {

                @Override
                public boolean accept(File file) {
                    return file.getName().endsWith(".xml");
                }

                @Override
                public String getDescription() {
                    return "Language Editor(*.xml)";
                }
            });
            int state = fileChooser.showSaveDialog(lu);
            if (state == JFileChooser.APPROVE_OPTION) {
                try {
                    file = fileChooser.getSelectedFile();
                    if(!file.getName().endsWith(".xml")) {
                        file = new File(file.getAbsolutePath()+".xml");
                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    jlang.getProp().storeToXML(fos, "注释部分");
                    fos.close();
                } catch (IOException ex) {
                }
            }
        } else if (e.getActionCommand().equals("Remove")) {
            jlang.removeRow();
        } else if (e.getActionCommand().equals("Add")) {
//            title = "添加键值对";
            temp = false;
            al = new Add_Language(jlang, temp);
            al.initJdAdd();
            al.jd_add.setVisible(true);
        } else if (e.getActionCommand().equals("Editor")) {
            if (jlang.isSelected()) {
                temp = true;
//                title = "编辑键值对";
                al = new Add_Language(jlang, temp);
                al.initJdAdd();
                al.setJfKeyText(jlang.getKeyText());
                al.setJfValueText(jlang.getValueText());
                al.jd_add.setVisible(true);
            }
        }
    }

}
