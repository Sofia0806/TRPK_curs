package View;

import com.company.DBWorker;
import com.company.model.SpisocList;
import com.company.model.SpisocTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class SpisocView extends JFrame {
    private JTable table;
    public static SpisocTableModel tableModel = new SpisocTableModel(new SpisocList());

    private JPanel panel1 = new JPanel();


    private JPanel panelTable = new JPanel();
    private JPanel panelMenuTable = new JPanel();
    private JPanel panelMenu = new JPanel();

    private JLabel labelFio = new JLabel("Введите ФИО:");
//    private JLabel labelSub = new JLabel("Введите Подразделение:");
//    private JLabel labelPost = new JLabel("Введите Должность:");
//    private JLabel labelAge = new JLabel("Введите возраст:");
//    private JLabel labelFl = new JLabel("Введите пол:");
//    private JLabel labelStatys = new JLabel("Введите статус:");
//    private JLabel labelOrder = new JLabel("Введите номер приказа:");

//    private JComboBox<String> cbFirst;
//    public static BookComboBoxModel cbmodel=new BookComboBoxModel();

    private JTextField textFio = new JTextField();
//    private JTextField textSub = new JTextField();
//    private JTextField textPost = new JTextField();
//    private JTextField textAge = new JTextField();
//    private JTextField textFl = new JTextField();
//    private JTextField textStatys = new JTextField();
//    private JTextField textOrder = new JTextField();

    //private JButton buttonAdd = new JButton("Принять на работу");
   // private JButton buttonDelete = new JButton("Уволить");
   // private JButton buttonUpdate = new JButton("Перевести сотрудника");

// private JButton buttonFilter=new JButton("Фильтр");

    //private JButton buttonOrg=new JButton("Приказы");
    //private JButton buttonCar = new JButton("Договоры");
    //private JButton buttonSpisoc = new JButton("Список");

    //пранировщик для формы
    private GridLayout layoutForm = new GridLayout(1, 2, 5, 12);
    //пранировщик для панели
    private GridLayout layoutPanel = new GridLayout(17, 1, 5, 12);
    private GridLayout layoutPanelЕ = new GridLayout(2, 1, 5, 12);
    private GridLayout layoutP = new GridLayout(1, 5, 5, 12);
    private BoxLayout layoutT = new BoxLayout(getContentPane(), BoxLayout.X_AXIS);
    private BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);

    private JButton buttonFilter = new JButton("Поиск");
    private JButton buttonClear = new JButton("Отменить поиск");

    public SpisocView() {
        super("Табель");
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


//        panelMenu.add(buttonCar);
//        panelMenu.add(buttonSpisoc);

        //panelMenu.add(buttonExel);
        tableModel.connectDB();

        panelMenuTable.setLayout(layoutPanel);

        panelMenuTable.add(labelFio);
        panelMenuTable.add(textFio);
//
        //panelMenuTable.add(buttonAdd);
        //panelMenuTable.add(buttonUpdate);
        //panelMenuTable.add(buttonDelete);
// panelMenuTable.add(buttonFilter);


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
//        buttonCar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ContractView v = new ContractView();
//            }
//        });
        buttonFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sub = textFio.getText();
                SpisocTableModel.filterDB(sub);
                SpisocView.tableModel.fireTableDataChanged();

            }
        });
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SpisocTableModel.connectDB();
                SpisocView.tableModel.connectDB();
                SpisocView.tableModel.fireTableDataChanged();
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
}
