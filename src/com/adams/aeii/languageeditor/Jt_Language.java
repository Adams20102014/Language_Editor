/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adams.aeii.languageeditor;

import java.util.Properties;
import javax.swing.JTable;

/**
 *
 * @author s1407003
 */
public class Jt_Language {
   
    private JTable jt_language;
   
    Properties prop;
    public Jt_Language() {
    
    }
    
    public JTable initJtLanguage() {
        jt_language = new JTable();
        
        return jt_language;
    }
}
