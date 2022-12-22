package airline.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDetails extends JFrame {

    public CustomerDetails() {
        initialize();
    }

    JLabel title, code;
    JTextField t1;
    JButton show;
    JTable table;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;

    private void initialize() {

        setTitle("CUSTOMER DETAILS");
        getContentPane().setBackground(Color.WHITE);
        setSize(1400,550);



        title = new JLabel("PASSENGER DETAILS:");
        title.setFont(new Font("Tahoma", Font.PLAIN,30));
        title.setBounds(50, 30, 300, 100);
        add(title);

        code = new JLabel("FLIGHT CODE:");
        code.setFont(new Font("Tahoma", Font.PLAIN, 17));
        code.setBounds(50, 130, 150, 20);
        add(code);

        t1 = new JTextField();
        t1.setBounds(200, 130, 100, 20);
        add(t1);

        show = new JButton("SHOW");
        show.setBounds(200, 180, 100, 20);
        add(show);

        table = new JTable();
        table.setBounds(30, 280, 1250, 200);
        add(table);

        l1 = new JLabel("PNR NO");
        l1.setBounds(70, 250, 80, 15);
        add(l1);

        l2 = new JLabel("NAME");
        l2.setBounds(230, 250, 80, 15);
        add(l2);

        l3 = new JLabel("GENDER");
        l3.setBounds(385, 250, 80, 15);
        add(l3);

        l4 = new JLabel("NATIONALITY");
        l4.setBounds(540, 250, 110, 15);
        add(l4);

        l5 = new JLabel("PASSPORT NO");
        l5.setBounds(690, 250, 150, 15);
        add(l5);

        l6 = new JLabel("PHONE NO");
        l6.setBounds(855, 250, 120, 15);
        add(l6);

        l7 = new JLabel("ADDRESS");
        l7.setBounds(1010, 250, 100, 15);
        add(l7);

        l8 = new JLabel("FLIGHT CODE");
        l8.setBounds(1150, 250, 100, 15);
        add(l8);

        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                try {
                    con c = new con();

                    String fc = t1.getText();
                    String sr = "select Flight_Code from passenger where Flight_Code = '"+fc+"'";
                    String str = "select PNR_NO, Name, Gender, Nationality, Passport_No, Phone_No, Address, Flight_Code from passenger where Flight_Code = '"+fc+"'";

                    ResultSet rs1 = c.s.executeQuery(sr);
                    if(rs1.next()){
                        ResultSet rs = c.s.executeQuery(str);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid Flight Code");
                    }

                }catch(SQLException e) {
                    e.printStackTrace();
                }
            }

        });

        setLayout(null);
        setLocation(85, 100);
        setVisible(true);
    }
}
