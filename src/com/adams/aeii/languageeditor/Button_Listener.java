/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.languageeditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
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
    
    public Button_Listener(Language_UI lu,Jt_Language jlang) {
        this.lu = lu;
        this.jlang = jlang;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("open")) {
            fileChooser = new JFileChooser();
            int state = fileChooser.showOpenDialog(lu);
            if (state == JFileChooser.APPROVE_OPTION) {
                try {
                    file = fileChooser.getSelectedFile();
                    FileReader read = new FileReader(file);
                    prop.load(read);
                    jlang.setProp(prop);
                } catch (IOException ex) {
                }
            }
        }else if(e.getActionCommand().equals("save")) {
        }else if(e.getActionCommand().equals("remove")) {
        }else if(e.getActionCommand().equals("add")) {
            al = new Add_Language();
            al.initJpAdd();
        }
    }

}
