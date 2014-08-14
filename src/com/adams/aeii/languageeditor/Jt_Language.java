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
   
    private final String [] columnNames = {"KEY","VALUE"};
    private Object[][] cellData = null;
    private Properties prop;
   
    public Jt_Language() {
    
    }
    
    public JTable initJtLanguage() {
        jt_language = new JTable();
        prop = new Properties();
        jt_language.setBounds(5, 10, 500, 420);
        return jt_language;
    }
    
    public void setCellDate(Object[][] cellData) {
        this.cellData = cellData;
    }
    
    public Object[][] getCellDta() {
        return cellData;
    }
    
    public void setProp(Properties prop) {
        this.prop = prop;
    }
    
    public Properties getProp() {
        return prop;
    }
}
