package View;

//import com.company.model.MyTableModel;
import com.company.DBWorker;
import com.company.model.WorkerList;
import com.company.model.WorkerTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class MainView extends JFrame {

//    private JTable table;
//    public static MyTableModel tableModel=new MyTableModel((new PublicationsList()));
//    private JPanel panelT=new JPanel();
//    private JPanel panelM=new JPanel();

//    private JButton buttonAdd=new JButton("Добавить запись");
//    private JButton buttonSearch=new JButton("Найти/Удалить запись");
//    private JButton buttonSearch2=new JButton("Найти/Изменить запись");
//    private JButton buttonLook=new JButton("Посмотреть договор");

//    private BoxLayout layout=new BoxLayout(getContentPane() ,BoxLayout.Y_AXIS);

    private JTable table;
    public static WorkerTableModel tableModel=new WorkerTableModel(new WorkerList());

    private JPanel panel1=new JPanel();


    private JPanel panelTable=new JPanel();
    private JPanel panelMenuTable=new JPanel();
    private JPanel panelMenu=new JPanel();

//    private JLabel labelFio=new JLabel("Введите ФИО:");
//    private JLabel labelSub=new JLabel("Введите Подразделение:");
//    private JLabel labelPost=new JLabel("Введите Должность:");
//    private JLabel labelAge=new JLabel("Введите возраст:");
//    private JLabel labelFl=new JLabel("Введите пол:");
//    private JLabel labelStatys=new JLabel("Введите статус:");
//    private JLabel labelOrder=new JLabel("Введите номер приказа:");

//    private JComboBox<String> cbFirst;
//    public static BookComboBoxModel cbmodel=new BookComboBoxModel();

//    private JTextField textFio=new JTextField();
//    private JTextField textSub=new JTextField();
//    private JTextField textPost=new JTextField();
//    private JTextField textAge=new JTextField();
//    private JTextField textFl=new JTextField();
//    private JTextField textStatys=new JTextField();
//    private JTextField textOrder=new JTextField();

    private JButton buttonAdd=new JButton("Принять на работу");
    private JButton buttonDelete=new JButton("Уволить");
    private JButton buttonUpdate=new JButton("Перевести сотрудника");
// private JButton buttonFilter=new JButton("Фильтр");

    private JComboBox<String> cbPub;
    private DefaultComboBoxModel<String> cbModel;
//    private JComboBox<String> cbPub2;
//    private DefaultComboBoxModel<String> cbModel2;
//
//    private JComboBox<String> cbPub3;
//    private DefaultComboBoxModel<String> cbModel3;
//    private JComboBox<String> cbPub4;
//    private DefaultComboBoxModel<String> cbModel4;
//
//    private JComboBox<String> cbPub5;
//    private DefaultComboBoxModel<String> cbModel5;

    //private JButton buttonOrg=new JButton("Приказы");
    private JButton buttonCar=new JButton("Договоры");
    private JButton buttonSpisoc=new JButton("Табель");

    // private JButton buttonExel=new JButton("Отчёт Excel");


    //пранировщик для формы
    private GridLayout layoutForm = new GridLayout(1, 2, 5, 12);
    //пранировщик для панели
    private GridLayout layoutPanel = new GridLayout(17, 1, 5, 12);
    private GridLayout layoutPanelЕ = new GridLayout(2, 1, 5, 12);
    private GridLayout layoutP= new GridLayout(1, 5, 5, 12);
    private BoxLayout layoutT=new BoxLayout(getContentPane() ,BoxLayout.X_AXIS);
    private BoxLayout layout=new BoxLayout(getContentPane() ,BoxLayout.Y_AXIS);

    private JButton buttonFilter=new JButton("Применить фильтр");
    private JButton buttonClear=new JButton("Сбросить фильтр");

    public MainView() {
        super("Сотрудники");
        this.setSize(900, 900);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

// this.setLayout(layoutForm);
        this.setLayout(layout);
//panelTable.setLayout(new FlowLayout(FlowLayout.CENTER));
// panelTable.setLayout();

        table = new JTable();
        table.setModel(tableModel);
        JScrollPane jScrollPane = new JScrollPane(table);
        panelTable.add(jScrollPane);

        cbModel = new DefaultComboBoxModel<String>();
        cbModel.addElement("Отдел_1");
        cbModel.addElement("Отдел_2");
        cbModel.addElement("Отдел_3");
        cbModel.addElement("Отдел_4");
        cbPub=new JComboBox<String>(cbModel);

//        cbModel2 = new DefaultComboBoxModel<String>();
//        cbModel2.addElement("Работает");
//        //cbModel2.addElement("Уволен");
//        cbPub2=new JComboBox<String>(cbModel2);
//
//        cbModel3 = new DefaultComboBoxModel<String>();
//        cbModel3.addElement("Отдел_1");
//        cbModel3.addElement("Отдел_2");
//        cbModel3.addElement("Отдел_3");
//        cbModel3.addElement("Отдел_4");
//        cbPub3=new JComboBox<String>(cbModel3);
//
//        cbModel4 = new DefaultComboBoxModel<String>();
//        cbModel4.addElement("Директор");
//        cbModel4.addElement("Техник");
//        cbModel4.addElement("Инженер");
//        cbModel4.addElement("Рабочий");
//        cbPub4=new JComboBox<String>(cbModel4);
//
//        cbModel5 = new DefaultComboBoxModel<String>();
//        cbModel5.addElement("Муж");
//        cbModel5.addElement("Жен");
//        cbPub5=new JComboBox<String>(cbModel5);

        this.add(panelMenu);
        this.add(panel1);
        panel1.setLayout(layoutForm);
        panel1.add(panelTable);
        panel1.add(panelMenuTable);
// panelTable.add(panelMenu);
//setLayout(layoutP);
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.X_AXIS));
        panelMenu.add(buttonFilter);
        panelMenu.add(buttonClear);

        panelMenu.add(cbPub);
        panelMenu.add(buttonCar);
        panelMenu.add(buttonSpisoc);

        //panelMenu.add(buttonExel);
        tableModel.connectDB();

        panelMenuTable.setLayout(layoutPanel);

//        panelMenuTable.add(labelFio);
//        panelMenuTable.add(textFio);
//        cbFirst = new JComboBox<>();
//        cbFirst.setModel(cbmodel);
//        panelMenuTable.add(cbFirst);

//        panelMenuTable.add(labelOrder);
//        panelMenuTable.add(textOrder);
//
//        panelMenuTable.add(labelSub);
//        panelMenuTable.add(cbPub3);
//
//        panelMenuTable.add(labelPost);
//        panelMenuTable.add(cbPub4);
//
//        panelMenuTable.add(labelAge);
//        panelMenuTable.add(textAge);
//
//        panelMenuTable.add(labelFl);
//        panelMenuTable.add(cbPub5);
//
//        panelMenuTable.add(labelStatys);
//        panelMenuTable.add(cbPub2);

        panelMenuTable.add(buttonAdd);
        panelMenuTable.add(buttonUpdate);
        panelMenuTable.add(buttonDelete);
// panelMenuTable.add(buttonFilter);


        AddListener addListener = new AddListener();
        buttonAdd.addActionListener(addListener);

        DeleteListener deleteListener = new DeleteListener();
        buttonDelete.addActionListener(deleteListener);
//
        UpdateListener updateListener = new UpdateListener();
        buttonUpdate.addActionListener(updateListener);
////


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    DBWorker.closeDB();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

//        buttonOrg.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                BookView v = new BookView();
//            }
//        });
//
        buttonCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContractView v = new ContractView();
            }
        });

        buttonSpisoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpisocView v = new SpisocView();
            }
        });

        buttonFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sub = cbPub.getSelectedItem().toString();
                WorkerTableModel.filterDB(sub);
                MainView.tableModel.fireTableDataChanged();

            }
        });
        buttonFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sub = cbPub.getSelectedItem().toString();
                WorkerTableModel.filterDB(sub);
                MainView.tableModel.fireTableDataChanged();

            }
        });
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkerTableModel.connectDB();
                MainView.tableModel.connectDB();
                MainView.tableModel.fireTableDataChanged();
            }
        });
// buttonExel.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// ExcelWindow v=new ExcelWindow();
// }
// });
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }



    public Object GetIndex(){
        Object o=table.getValueAt(table.getSelectedRow(),0);
        return o;
    }
    public Object GetIndex1(){
        Object o=table.getValueAt(table.getSelectedRow(),2);
        return o;
    }
    public Object GetIndex2(){
        Object o=table.getValueAt(table.getSelectedRow(),3);
        return o;
    }

//    private boolean checkInput(){
//        try {
//            if (textFio.getText().trim().length() == 0 || textAge.getText().trim().length() == 0 || textOrder.getText().trim().length() == 0) {
//                JOptionPane.showMessageDialog(null, "Введите значения в поля");
//                return false;
//            } else if (Integer.parseInt(textOrder.getText()) < 0) {
//                JOptionPane.showMessageDialog(null, "Введите корректный номер приказа");
//                return false;
//            } else if (Integer.parseInt(textAge.getText()) < 0) {
//                JOptionPane.showMessageDialog(null, "Введите корректный возраст");
//                return false;
//            } else return true;
//        }catch (NumberFormatException ex){
//            JOptionPane.showMessageDialog(null, "Введите корректные данные");
//            return false;
//        }
//
//    }

    public class AddListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//            if (checkInput()) {
//                try {
//
//                    MainView.tableModel.connectDB(); DBWorker.insertContractDB(textFio.getText());
////                    DBWorker.insertWorkerDB(textFio.getText(), cbPub3.getSelectedItem().toString(), cbPub4.getSelectedItem().toString(), Integer.valueOf(textAge.getText()), cbPub5.getSelectedItem().toString(), cbPub2.getSelectedItem().toString(), Integer.valueOf(textOrder.getText()));
////                    JOptionPane.showMessageDialog(null, "Запись успешно добавлена");
//                    tableModel.fireTableDataChanged();
//                    tableModel.connectDB();
////                        MainView.tableModel.connectDB();
//
//
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//            }


            AddView v = new AddView();

        }
    }
    public class UpdateListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

//            try{
//                String fio= (String) GetIndex();
//                DBWorker.updateWorkerDB(fio,textFio.getText(), cbPub3.getSelectedItem().toString(), cbPub4.getSelectedItem().toString(), Integer.valueOf(textAge.getText()),cbPub5.getSelectedItem().toString(), cbPub2.getSelectedItem().toString(), Integer.valueOf(textOrder.getText()));
//                JOptionPane.showMessageDialog(null,"Запись успешно изменена");
//                MainView.tableModel.connectDB();
//                tableModel.fireTableDataChanged();
//
////                        MainView.tableModel.connectDB();
//
//
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
            try {
                String fio = (String) GetIndex();
                String sub = (String) GetIndex1();
                String post = (String) GetIndex2();
                PeremView.labelFio2 = new JLabel(fio);
                //PeremView.labelSub2_ = new JLabel(sub);
                //PeremView.labelPost2_ = new JLabel(post);

                //PeremView.labelPost2_ = new JLabel(post);
                PeremView v = new PeremView();
            }catch (ArrayIndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(null,"Выберите запись");
            }

        }

    }
    public class DeleteListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                String fio = (String) GetIndex();
                String sub = (String) GetIndex1();
                String post = (String) GetIndex2();
                DeleteView.labelFio_ = new JLabel(fio);
                DeleteView.labelSub_ = new JLabel(sub);
                DeleteView.labelPost_ = new JLabel(post);
                DeleteView v =new DeleteView();
            }catch (ArrayIndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(null,"Выберите запись");
            }
        }

    }
}
