/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.languageeditor;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author s1407003
 */
public class Add_Language extends JFrame {

    private JLabel jl_key;
    private JLabel jl_value;

    private JTextField jf_key;
    private JTextField jf_value;

    JDialog jd_add;

    private JButton btn_ok;
    private JButton btn_cancel;

    private JPanel jp_input;

    private Jt_Language jlang;
            
    public Add_Language(Jt_Language jlang) {
        this.jlang = jlang;
    }

    @SuppressWarnings("empty-statement")
    public JDialog initJdAdd() {
        jd_add = new JDialog(this);
        jd_add.setTitle("添加键值对");
        jd_add.setLayout(null);
//        jd_add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jd_add.getContentPane().setPreferredSize(new Dimension(240, 140));
        jd_add.pack();
        jd_add.setLocationRelativeTo(null);
        jd_add.setResizable(false);
//        jd_add.setModal(true);
//        jd_add.setBorder(BorderFactory.createTitledBorder("添加键值对"));
        jp_input = new JPanel(new GridLayout(2, 2));
        jl_key = new JLabel("Key:");
        jl_value = new JLabel("Value:");
        jf_key = new JTextField(10);
        jf_value = new JTextField(10);

        jp_input.add(jl_key);
        jp_input.add(jf_key);
        jp_input.add(jl_value);
        jp_input.add(jf_value);
        
        jp_input.setBounds(10, 10, 230, 80);

        btn_ok = new JButton("Ok");
        btn_ok.setBounds(50, 110, 80, 30);
        btn_ok.addActionListener(new Add_Listener(this,jlang));
        btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(140, 110, 80, 30);
        btn_cancel.addActionListener(new Add_Listener(this,jlang));;

        jd_add.add(jp_input);
        jd_add.add(btn_ok);
        jd_add.add(btn_cancel);

        jd_add.setVisible(true);
        return jd_add;
    }
    
    public void setJfKeyText(String key) {
        jf_key.setText(key);
    }
    
    public String getJfKeyText() {
//        System.out.println(jf_key.getText());
        return jf_key.getText();
    }
    
    public void setJfValueText(String value) {
        jf_value.setText(value);
    }
    
    public String getJfValueText() {
//        System.out.println(jf_value.getText());
        return jf_value.getText();
    }
    
}
