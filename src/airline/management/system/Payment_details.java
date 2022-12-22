package airline.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Payment_details extends JFrame {

    public static void main(String [] args) {

        new Payment_details();
    }

    JLabel pay;
    JLabel pnr, phone, cheque, card, amt, date, no;
    JTextField t1;
    JTable table;
    JButton show;

    public Payment_details() {
        initialize();
    }

    private void initialize() {
        setTitle("PAYMENT INFO");
        getContentPane().setBackground(Color.WHITE);
        setSize(870, 490);
        setLayout(null);

        pay = new JLabel("PAYMENT DETAILS");
        pay.setFont(new Font("Tahoma", Font.PLAIN, 30));
        pay.setBounds(60, 20, 300, 40);
        add(pay);

        pnr = new JLabel("PNR NO:");
        pnr.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pnr.setBounds(60, 110, 150, 25);
        add(pnr);

        t1 = new JTextField();
        t1.setBounds(240, 110, 150, 25);
        add(t1);

        no = new JLabel("PNR NO:");
        no.setFont(new Font("Tahoma", Font.PLAIN, 15));
        no.setBounds(60, 250, 100, 17);
        add(no);

        phone = new JLabel("PHONE NO:");
        phone.setFont(new Font("Tahoma", Font.PLAIN,15));
        phone.setBounds(190, 250, 100, 17);
        add(phone);

        cheque = new JLabel("CHEQUE NO:");
        cheque.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cheque.setBounds(330, 250, 100, 17);
        add(cheque);


        card = new JLabel("CARD NO:");
        card.setFont(new Font("Tahoma", Font.PLAIN, 15));
        card.setBounds(470, 250, 100, 17);
        add(card);


        amt = new JLabel("PAID AMOUNT:");
        amt.setFont(new Font("Tahoma", Font.PLAIN, 15));
        amt.setBounds(590, 250, 120, 17);
        add(amt);



        date = new JLabel("PAY DATE:");
        date.setFont(new Font("Tahoma", Font.PLAIN, 15));
        date.setBounds(730, 250, 100, 17);
        add(date);


        show = new JButton("SHOW");
        show.setBounds(240, 160, 150, 25);
        add(show);

        table = new JTable();
        table.setBounds(50, 280, 800, 90);
        add(table);

        show.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae) {
                try {
                    String PNR = t1.getText();

                    con c = new con();

                    String sr = "select PNR_NO from payment where PNR_NO = '"+PNR+"'";
                    ResultSet r1 = c.s.executeQuery(sr);
                    if(r1.next()) {
                        String str = "select PNR_NO, Phone_No, Cheque_No, Card_No, Paid_Amount, Pay_Date from payment where PNR_NO = '"+PNR+"'";

                        ResultSet r = c.s.executeQuery(str);
                        table.setModel(DbUtils.resultSetToTableModel(r));
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "PNR Does not Exists");
                    }


                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(960, 590);
        setLocation(250, 50);
        setVisible(true);


    }
}
