package com.company.model;

import com.company.DBWorker;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;

public class WorkerTableModel extends AbstractTableModel {
    public static WorkerList data=new WorkerList();
    public WorkerTableModel(WorkerList pub){
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
            DBWorker.readWorkerDB();
            data = DBWorker.getArr();
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
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "ФИО";
            case 1: return "Номер приказа";
            case 2: return "Подразделение";
            case 3: return "Должность";
            case 4: return "Возраст";
            case 5: return "Пол";
            case 6: return "Статус";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Worker p = data.Workers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getFio();
            case 1:
                return p.getNomer_order();
            case 2:
                return p.getSub();
            case 3:
                return p.getPost();
            case 4:
                return p.getAge();
            case 5: {
                return p.getFloor();
            }
            case 6: {
                return p.getStatys();
            }

        }
        return "default";
    }
    public Worker SearchPub(String fio) {
        Worker searchedPub = data.search(fio);
        return searchedPub;
    }

    public static void filterDB(String sub){
        data.Workers.clear();
        try {
            DBWorker.filter(sub);
            data = DBWorker.getArr();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
