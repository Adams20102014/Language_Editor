/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.languageeditor;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;  
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author s1407003
 */
public class Language_UI extends JFrame {

    private final Button btn;
    private final Jt_Language jlg;
    
    public Language_UI() {
        this.getContentPane().setPreferredSize(new Dimension(500,500));
        this.pack();
        this.setTitle("Language Editor");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        
        ImageIcon icon = new ImageIcon(this.getClass().getResource("\\image\\aeii.png"));
        this.setIconImage(icon.getImage());
        
        jlg = new Jt_Language();
        btn = new Button(this,jlg);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        this.getContentPane().add(jlg.initJtLanguage());
        this.getContentPane().add(btn.initJpButton());
        this.setVisible(true);
        
    }
    
    public static void main (String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new Language_UI();
    }
}