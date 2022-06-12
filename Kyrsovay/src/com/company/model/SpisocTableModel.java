package com.company.model;

import com.company.DBWorker;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;

public class SpisocTableModel extends AbstractTableModel {
    public static SpisocList data=new SpisocList();
    public SpisocTableModel(SpisocList pub){
        try{
            DBWorker.connectionBD();
            DBWorker.newTable();
            //connectDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        this.data=pub;
    }
    public static void connectDB(){
        data.clear();
       try {
            DBWorker.readSpisocDB();
            data = DBWorker.getSpi();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public int getRowCount() {
        return data.getCount();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "ФИО";
            case 1: return "Подразделение";
            case 2: return "Должность";
            case 3: return "Дата принятия";
            case 4: return "Дата увольнения";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Spisoc p = data.Spisocs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getFio();
            case 1:
                return p.getSub();
            case 2:
                return p.getPost();
            case 3:
                return p.getDate1();
            case 4:
                return p.getDate2();
            }
        return "default";
    }
    public Spisoc SearchPub(String fio) {
        Spisoc searchedPub = data.search(fio);
        return searchedPub;
    }

    public static void filterDB(String S_FIO){
        data.Spisocs.clear();
        try {
            DBWorker.filterSpi(S_FIO);
            data = DBWorker.getSpi();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
