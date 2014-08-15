/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.languageeditor;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author s1407003
 */
public class Jt_Language {

    private JTable jt_language;

    private final String[] columnNames = {"KEY", "VALUE"};
    private Object[][] cellData = null;
    private Properties prop;
    private JScrollPane js_prop;

    private DefaultTableModel model;

    private int row;

    public Jt_Language() {

    }

    public JScrollPane initJsProp() {
        jt_language = new JTable();
        jt_language.setRowHeight(20);
        prop = new Properties();
//        jt_language.setEnabled(false);
//        cellData = new Object[100][100];
        js_prop = new JScrollPane(jt_language);
//        js_prop.setBorder(BorderFactory.createTitledBorder("键值对应关系"));
        js_prop.setBounds(5, 10, 500, 420);
        return js_prop;
    }

//    public void setCellDate(Object[][] cellData) {
//        this.cellData = cellData;
//    }
//    
//    public Object[][] getCellDta() {
//        return cellData;
//    }
//    
    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public Properties getProp() {
        return prop;
    }

    public void setCellData() {
        int key_count = prop.keySet().size();
        cellData = new Object[key_count][2];
    }

    public void getCellData() {
        Iterator itr = prop.entrySet().iterator();
        int i = 0;
        int j = 0;
        while (itr.hasNext()) {
            Entry e = (Entry) itr.next();
            cellData[i][j] = e.getKey().toString();
            j++;
            cellData[i][j] = e.getValue().toString();
            j = 0;
            i++;
        }
    }

    public void getJtLanguage() {
        model = new DefaultTableModel(cellData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jt_language.setModel(model);
    }

    public void removeRow() {
//        DefaultTableModel tableModel = (DefaultTableModel) jt_language.getModel();
        int row = jt_language.getSelectedRow();
        System.out.println(row);
        String cellValue = (String) model.getValueAt(row, 0);
        model.removeRow(row);
        prop.remove(cellValue);
    }

    public boolean isSelected() {
        if (jt_language.getSelectedRow() == -1) {
            return false;
        } else {
            return this.getKeyText() != null;
        }
    }

    public String getKeyText() {
        String KeyText = (String) model.getValueAt(jt_language.getSelectedRow(), 0);
        return KeyText;
    }

    public String getValueText() {
        String ValueText = (String) model.getValueAt(jt_language.getSelectedRow(), 1);
        return ValueText;
    }

    public void addCellData(String key, String value) {
        int i = cellData.length;
        cellData = new Object[i+1][2];
        this.getCellData();
//        for (; i < cellData.length; i++) {
//            if (cellData[i][0] != null) {
//                continue;
//            } else {
//                break;
//            }
//        }
//        System.out.println(cellData[20][0]);
        System.out.println(i);
        cellData[i][0] = key;
        cellData[i][1] = value;
        prop.put(key, value);
    }

    public void getNewJtLanguage() {
        model = new DefaultTableModel(cellData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jt_language.setModel(model);
    }

    public void updateCellData(String key, String value) {
        if (jt_language.getSelectedRow() != -1) {
            row = jt_language.getSelectedRow();
        }
//        System.out.println(row);
        cellData[row][0] = key;
        cellData[row][1] = value;
        prop.put(key, value);
    }

    public boolean isExisted(String key) {
        return prop.containsKey(key);
    }
}
