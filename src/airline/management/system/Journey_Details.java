package airline.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Journey_Details extends JFrame {

    public static void main (String [] args) {
        new Journey_Details();
    }

    JLabel source, destination;
    JLabel journey, pnr, fc, date, ticket, time, from, to;
    JComboBox src, dst;
    JButton show;
    JTable table;

    public Journey_Details() {

        setTitle("ROUTE DETAILS");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);

        source = new JLabel("SOURCE:");
        source.setFont(new Font("Tahoma", Font.PLAIN,20));
        source.setBounds(280, 100, 150, 30);
        add(source);

        destination = new JLabel("DESTINATION:");
        destination.setFont(new Font("Tahoma", Font.PLAIN,20));
        destination.setBounds(580, 100, 200, 30);
        add(destination);

        String sr[] = {"MUMBAI", "DELHI", "GUJARAT", "HYDERABAD", "BANGALORE", "CHENNAI"};
        String dt[] = {"DELHI", "MUMBAI", "GUJARAT", "HYDERABAD", "BANGALORE", "CHENNAI"};

        src = new JComboBox(sr);
        dst = new JComboBox(dt);
        src.setBounds(400, 100, 100, 30);
        add(src);
        dst.setBounds(740, 100, 100, 30);
        add(dst);

        show = new JButton("SHOW");
        show.setBounds(495, 170, 100, 30);
        add(show);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        journey = new JLabel("JOURNEY DETAILS");
        journey.setFont(new Font("Tahoma", Font.PLAIN, 30));
        journey.setBounds(430, 30, 360, 30);
        add(journey);


        pnr = new JLabel("PNR NO");
        pnr.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pnr.setBounds(55,270,85,20);
        add(pnr);

        ticket = new JLabel("TICKET ID");
        ticket.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ticket.setBounds(200,270,100,20);
        add(ticket);


        fc = new JLabel("FLIGHT CODE");
        fc.setFont(new Font("Tahoma", Font.PLAIN, 15));
        fc.setBounds(347, 270, 150, 20);
        add(fc);

        date = new JLabel("JOURNEY DATE");
        date.setFont(new Font("Tahoma", Font.PLAIN,15));
        date.setBounds(495, 270, 150, 20);
        add(date);

        time = new JLabel("JOURNEY TIME");
        time.setFont(new Font("Tahoma", Font.PLAIN, 15));
        time.setBounds(647, 270, 150, 20);
        add(time);

        from = new JLabel("SOURCE");
        from.setFont(new Font("Tahoma", Font.PLAIN, 15));
        from.setBounds(800, 270, 100, 20);
        add(from);

        to = new JLabel("DESTINATION");
        to.setFont(new Font("Tahoma", Font.PLAIN, 15));
        to.setBounds(945, 270, 150, 20);
        add(to);

        table = new JTable();
        table.setBounds(40, 310, 1050, 150);
        add(table);


        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                try {
                    con c = new con();

                    String s = (String) src.getSelectedItem();
                    String d = (String) dst.getSelectedItem();

                    String sr = "select Source, Destination from reservation where Source = '"+s+"' and Destination = '"+d+"'";
                    String str = "SELECT PNR_NO, Ticket_Id, Flight_Code, Journey_Date, Journey_Time, Source, Destination FROM reservation WHERE Source = '"+s+"' AND Destination = '"+d+"'";
                    ResultSet rs1 = c.s.executeQuery(sr);
                    if(rs1.next()) {
                        ResultSet rs = c.s.executeQuery(str);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "No Flights Between the above Source and Destination");
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(1150, 600);
        setLocation(250, 50);
        setVisible(true);

    }
}
