package View;

import View.MainView;
import View.SpisocView;
import com.company.DBWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteView extends JFrame {

    private JComboBox<String> cbPub2;
    private DefaultComboBoxModel<String> cbModel2;

    private JComboBox<String> cbPub3;
    private DefaultComboBoxModel<String> cbModel3;
    private JComboBox<String> cbPub4;
    private DefaultComboBoxModel<String> cbModel4;

    private JComboBox<String> cbPub5;
    private DefaultComboBoxModel<String> cbModel5;

    private JLabel labelFio=new JLabel("ФИО:");
    public static JLabel labelFio_;
    private JLabel labelSub=new JLabel("Подразделение:");
    public static JLabel labelSub_;
    private JLabel labelPost=new JLabel("Должность:");
    public static JLabel labelPost_;
    private JLabel labelOrder=new JLabel("Введите номер приказа:");
    private JLabel labelDate2=new JLabel("Введите дату увольнения:");


    public static JTextField textFio;
    private JTextField textOrder=new JTextField();
    private JTextField textDate2=new JTextField();


    private GridLayout layoutPanel = new GridLayout(8, 2, 5, 12);
    private GridLayout layout = new GridLayout(3, 1, 5, 12);
    JPanel panel=new JPanel();

    private JButton buttonAdd = new JButton("Уволить");

    public DeleteView(){
        super("Уволить");
        this.setSize(500,200);
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
        panel.add(labelFio_);

        panel.add(labelSub);
        panel.add(labelSub_);

        panel.add(labelPost);
        panel.add(labelPost_);
//        panel.add(textFio);

        panel.add(labelOrder);
        panel.add(textOrder);

        panel.add(labelDate2);
        panel.add(textDate2);


        AddListener3 addListener = new AddListener3();
        buttonAdd.addActionListener(addListener);
        add(buttonAdd);

        this.pack();
        this.setLocationRelativeTo(null);


    }
//    private boolean checkInput(){
//        try {
//            if (textName.getText().trim().length() == 0 || textQuantity.getText().trim().length() == 0 || textPrice.getText().trim().length() == 0 || textAvtor.getText().trim().length() == 0 || textProperty_1.getText().trim().length() == 0 || textProperty_2.getText().trim().length() == 0) {
//                JOptionPane.showMessageDialog(null, "Введите значения в поля");
//                return false;
//            } else if (Integer.parseInt(textQuantity.getText()) < 0) {
//                JOptionPane.showMessageDialog(null, "Введите корректное количество");
//                return false;
//            } else if (Integer.parseInt(textPrice.getText()) < 0) {
//                JOptionPane.showMessageDialog(null, "Введите корректную цену");
//                return false;
//            } else if (Integer.parseInt(textProperty_1.getText()) < 0) {
//                JOptionPane.showMessageDialog(null, "Введите корректную характеристику");
//                return false;
//            } else return true;
//        }catch (NumberFormatException ex){
//            JOptionPane.showMessageDialog(null, "Введите корректные данные");
//            return false;
//        }
//
//    }
    public class AddListener3 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {

                    DBWorker.delete(labelFio_.getText(), labelSub_.getText(), labelPost_.getText(),Integer.valueOf(textOrder.getText()), textDate2.getText());

                    JOptionPane.showMessageDialog(null, "Статус изменен");
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
