 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.languageeditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author s1407003
 */
public class Add_Listener implements ActionListener {

    private Add_Language al;
    private final Jt_Language jlang;

    public Add_Listener(Add_Language al, Jt_Language jlang) {
        this.al = al;
        this.jlang = jlang;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Ok")) {
            if ((!al.getJfKeyText().equals("")) && (!al.getJfValueText().equals(""))) {
//                System.out.println(al.getJfKeyText() + "\n" + al.getJfValueText());
                if (al.jd_add.getTitle().equals("添加键值对")) {
//                    System.out.println(al.getJfKeyText() + "\n" + al.getJfValueText());
                    if(jlang.isExisted(al.getJfKeyText())) {
                         JOptionPane.showMessageDialog(al, "输入的key已经存在！", "提示信息", JOptionPane.WARNING_MESSAGE);
                    }else {
                        jlang.addCellData(al.getJfKeyText(), al.getJfValueText());
                        jlang.getNewJtLanguage();
                        al.jd_add.dispose();
                    }
                } else if (al.jd_add.getTitle().equals("编辑键值对")) {
//                    System.out.println(al.getJfKeyText() + "\n" + al.getJfValueText());
                    jlang.updateCellData(al.getJfKeyText(), al.getJfValueText());
                    jlang.getNewJtLanguage();
                    al.jd_add.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(al, "输入的key和value信息不完整！", "提示信息", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getActionCommand().equals("Cancel")) {
            al.jd_add.dispose();
        }
    }

}
