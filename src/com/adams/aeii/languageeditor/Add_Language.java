/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adams.aeii.languageeditor;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author s1407003
 */
public class Add_Language {
    
    private JLabel jl_key;
    private JLabel jl_value;
    
    private JTextField jf_key;
    private JTextField jf_value;
    
    private JPanel jp_add;
    
    private JButton btn_ok;
    private JButton btn_cancel;
    
    public Add_Language() {
    
    }
    
    @SuppressWarnings("empty-statement")
    public JPanel initJpAdd() {
        jp_add = new JPanel(new GridLayout(3,2));
        jp_add.setBorder(BorderFactory.createTitledBorder("添加键值对"));
        jl_key = new JLabel("键:");
        jl_value = new JLabel("值:");
        jf_key = new JTextField(10);
        jf_value = new JTextField(10);
        
        btn_ok = new JButton("Ok");
        btn_ok.addActionListener(new Add_Listener());
        btn_cancel = new JButton("Cancel");
        btn_cancel.addActionListener(new Add_Listener());;
        
        jp_add.add(jl_key);
        jp_add.add(jf_key);
        jp_add.add(jl_value);
        jp_add.add(jf_value);
        jp_add.add(btn_ok);
        jp_add.add(btn_cancel);
        return jp_add;
    }
}
