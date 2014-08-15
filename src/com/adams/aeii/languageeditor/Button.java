/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.languageeditor;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author s1407003
 */
public class Button {

    private JPanel jp_button;
    private JButton btn_add;
    private JButton btn_remove;
    private JButton btn_save;
    private JButton btn_open;
    private JButton btn_editor;

    private final Language_UI lu;
    private final Jt_Language jlang;

//    private final boolean isEnabled = false;
    public Button(Language_UI lu, Jt_Language jlang) {
        this.lu = lu;
        this.jlang = jlang;
    }

    public JPanel initJpButton() {
        jp_button = new JPanel();
        jp_button.setLayout(null);
//        jp_button.setBorder(BorderFactory.createTitledBorder("按钮操作区域"));
        btn_editor = new JButton("Editor");
        btn_editor.setEnabled(false);
        btn_editor.setBounds(10, 10, 80, 30);
        btn_editor.addActionListener(new Button_Listener(lu, jlang,this));
        btn_add = new JButton("Add");
        btn_add.setEnabled(false);
        btn_add.setBounds(110, 10, 80, 30);
        btn_add.addActionListener(new Button_Listener(lu, jlang,this));
        btn_remove = new JButton("Remove");
        btn_remove.setEnabled(false);
        btn_remove.setBounds(210, 10, 80, 30);
        btn_remove.addActionListener(new Button_Listener(lu, jlang,this));
        btn_save = new JButton("Save");
        btn_save.setEnabled(false);
        btn_save.setBounds(310, 10, 80, 30);
        btn_save.addActionListener(new Button_Listener(lu, jlang,this));
        btn_open = new JButton("Open");
        btn_open.setBounds(410, 10, 80, 30);
        btn_open.addActionListener(new Button_Listener(lu, jlang,this));

        jp_button.add(btn_editor);
        jp_button.add(btn_add);
        jp_button.add(btn_remove);
        jp_button.add(btn_save);
        jp_button.add(btn_open);
        jp_button.setBounds(5, 450, 500, 50);
        return jp_button;
    }

    public void getEnabled(boolean isEnabled) {
        if (isEnabled == true) {
            btn_editor.setEnabled(true);
            btn_add.setEnabled(true);
            btn_remove.setEnabled(true);
            btn_save.setEnabled(true);
        }
    }
}
