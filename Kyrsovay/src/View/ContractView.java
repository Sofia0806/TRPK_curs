package View;

import View.MainView;
import com.company.DBWorker;
import com.company.model.Worker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ContractView extends JFrame {
    private JButton buttonSearch=new JButton("Посмотреть договор");
    private JTextField textId=new JTextField();
    private JLabel label=new JLabel("Введите ФИО:");
    private GridLayout layout = new GridLayout(5, 1, 5, 12);
    private JTextArea infoText=new JTextArea();
    public ContractView() {
        super("Договоры");
        this.setSize(350,600);
        setVisible(true);
        this.setLayout(layout);
        this.add(label);
        this.add(textId);
        this.add(infoText);
        infoText.setVisible(false);
        this.add(buttonSearch);

        buttonSearch.addActionListener(new SearchListener());

        this.setLocationRelativeTo(null);

    }
    private boolean checkInput(){
        try {
            if(Integer.parseInt(textId.getText())<0){
                JOptionPane.showMessageDialog(null, "Такого ID нет");
                return false;
            }
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Такого ID нет");
            return false;
        }
        return true;
    }
    public class SearchListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           //if(checkInput()) {

            try {
                String ind = (textId.getText());
                Worker p = MainView.tableModel.SearchPub(ind);
                int id= DBWorker.select(textId.getText());
                String str="";
                str="Номер договора: "+id+p.print()+"\n";

                infoText.setText(str);
                infoText.setVisible(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

           // }
        }
    }


}
