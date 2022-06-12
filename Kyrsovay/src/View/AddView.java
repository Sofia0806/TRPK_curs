package View;

import com.company.DBWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class AddView extends JFrame {

    private JComboBox<String> cbPub2;
    private DefaultComboBoxModel<String> cbModel2;

    private JComboBox<String> cbPub3;
    private DefaultComboBoxModel<String> cbModel3;
    private JComboBox<String> cbPub4;
    private DefaultComboBoxModel<String> cbModel4;

    private JComboBox<String> cbPub5;
    private DefaultComboBoxModel<String> cbModel5;

    private JLabel labelFio=new JLabel("Введите ФИО:");
    private JLabel labelSub=new JLabel("Введите Подразделение:");
    private JLabel labelPost=new JLabel("Введите Должность:");
    private JLabel labelAge=new JLabel("Введите возраст:");
    private JLabel labelFl=new JLabel("Введите пол:");
    private JLabel labelStatys=new JLabel("Введите статус:");
    private JLabel labelOrder=new JLabel("Введите номер приказа:");
    private JLabel labelDate=new JLabel("Введите дату принятия:");


    private JTextField textFio=new JTextField();
    private JTextField textSub=new JTextField();
    private JTextField textPost=new JTextField();
    private JTextField textAge=new JTextField();
    private JTextField textFl=new JTextField();
    private JTextField textStatys=new JTextField();
    private JTextField textOrder=new JTextField();
    private JTextField textDate=new JTextField();


    private GridLayout layoutPanel = new GridLayout(8, 2, 5, 12);
    private GridLayout layout = new GridLayout(3, 1, 5, 12);
    JPanel panel=new JPanel();

    private JButton buttonAdd = new JButton("Принять на работу");

    public AddView(){
        super("Принять");
        this.setSize(500,100);
        setResizable(false);
        setVisible(true);


        cbModel2 = new DefaultComboBoxModel<String>();
        cbModel2.addElement("Работает");
        //cbModel2.addElement("Уволен");
        cbPub2=new JComboBox<String>(cbModel2);

        cbModel3 = new DefaultComboBoxModel<String>();
        cbModel3.addElement("Отдел_1");
        cbModel3.addElement("Отдел_2");
        cbModel3.addElement("Отдел_3");
        cbModel3.addElement("Отдел_4");
        cbPub3=new JComboBox<String>(cbModel3);

        cbModel4 = new DefaultComboBoxModel<String>();
        cbModel4.addElement("Директор");
        cbModel4.addElement("Техник");
        cbModel4.addElement("Инженер");
        cbModel4.addElement("Рабочий");
        cbPub4=new JComboBox<String>(cbModel4);

        cbModel5 = new DefaultComboBoxModel<String>();
        cbModel5.addElement("Муж");
        cbModel5.addElement("Жен");
        cbPub5=new JComboBox<String>(cbModel5);

        panel.setLayout(layoutPanel);
        setLayout(layout);


        this.add(panel);
        panel.add(labelFio);
        panel.add(textFio);

        panel.add(labelSub);
        panel.add(cbPub3);

        panel.add(labelPost);
        panel.add(cbPub4);

        panel.add(labelAge);
        panel.add(textAge);

        panel.add(labelFl);
        panel.add(cbPub5);

        panel.add(labelStatys);
        panel.add(cbPub2);

        panel.add(labelOrder);
        panel.add(textOrder);

        panel.add(labelDate);
        panel.add(textDate);

        AddListener1 addListener = new AddListener1();
        buttonAdd.addActionListener(addListener);
        add(buttonAdd);

        this.pack();
        this.setLocationRelativeTo(null);


    }
    private boolean checkInput(){
        try {
            if (textFio.getText().trim().length() == 0 || textAge.getText().trim().length() == 0 || textOrder.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Введите значения в поля");
                return false;
            } else if (Integer.parseInt(textOrder.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "Введите корректный номер приказа");
                return false;
            } else if (Integer.parseInt(textAge.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "Введите корректный возраст");
                return false;
            } else return true;
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Введите корректные данные");
            return false;
        }

    }

    public class AddListener1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (checkInput()) {
                try {
                    DBWorker.insertContractDB(textFio.getText());
                    DBWorker.insertWorkerDB(textFio.getText(), cbPub3.getSelectedItem().toString(), cbPub4.getSelectedItem().toString(), Integer.valueOf(textAge.getText()), cbPub5.getSelectedItem().toString(), cbPub2.getSelectedItem().toString(), Integer.valueOf(textOrder.getText()));
                    DBWorker.insertSpisocDB(textFio.getText(), cbPub3.getSelectedItem().toString(), cbPub4.getSelectedItem().toString(), Date.valueOf(textDate.getText()), null);

                    JOptionPane.showMessageDialog(null, "Запись успешно добавлена");
                    MainView.tableModel.fireTableDataChanged();
                    MainView.tableModel.connectDB();
                    SpisocView.tableModel.fireTableDataChanged();
                    SpisocView.tableModel.connectDB();
                    MainView.tableModel.connectDB();


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
