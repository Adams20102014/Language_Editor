/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.languageeditor;

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
    
    private Language_UI lu;
    private Jt_Language jlang;

    public Button(Language_UI lu,Jt_Language jlang) {
        this.lu = lu;
        this.jlang = jlang;
    }

    public JPanel initJpButton() {
        jp_button = new JPanel();
        jp_button.setBorder(BorderFactory.createTitledBorder("按钮操作区域"));
        btn_add = new JButton("add");
        btn_add.addActionListener(new Button_Listener(lu,jlang));
        btn_remove = new JButton("remove");
        btn_remove.addActionListener(new Button_Listener(lu,jlang));
        btn_save = new JButton("save");
        btn_save.addActionListener(new Button_Listener(lu,jlang));
        btn_open = new JButton("open");
        btn_open.addActionListener(new Button_Listener(lu,jlang));

        jp_button.add(btn_add);
        jp_button.add(btn_remove);
        jp_button.add(btn_save);
        jp_button.add(btn_open);
        jp_button.setBounds(5, 450, 500, 100);
        return jp_button;
    }
}
