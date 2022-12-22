package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class cancel extends JFrame {

    public static void main(String [] args) {
        new cancel();
    }

    JLabel cancellation, PNR, cancel, fc, date;
    private JTextField t1, t2, t3;
    JButton c;
    JComboBox day, month, year;

    public cancel() {
        initialize();
    }

    private void initialize() {
        setTitle("CANCELLATION");
        getContentPane().setBackground(Color.WHITE);
        setBounds(100, 100, 800, 480);
        setLayout(null);

        Container x = getContentPane();
        x.setLayout(null);

        cancellation = new JLabel("CANCELLATION");
        cancellation.setFont(new Font("Tahoma", Font.PLAIN, 30));
        cancellation.setBounds(210, 25, 260, 40);
        x.add(cancellation);


        PNR = new JLabel("PNR NO:");
        PNR.setFont(new Font("Tahoma", Font.PLAIN, 20));
        PNR.setBounds(60,150,200,25);
        x.add(PNR);

        t1 = new JTextField();
        t1.setBounds(290, 150, 150, 20);
        x.add(t1);

        cancel = new JLabel("CANCELLATION NO:");
        cancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cancel.setBounds(60, 200, 200, 25);
        x.add(cancel);

        t2 = new JTextField();
        t2.setBounds(290, 200, 150, 20);
        x.add(t2);

        date = new JLabel("CANCELLATION DATE:");
        date.setFont(new Font("Tahoma", Font.PLAIN,20));
        date.setBounds(60, 250, 220, 25);
        x.add(date);

        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", " 10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        String years[] = {"2002", "2003", "2004", "2005", "2006", "2007", "2008","2009", "2010","2011",
                "2012", "2013", "2014", "2015", "2016", "2018", "2019", "2020", "2021", "2022", "2023"};

        day = new JComboBox(days);
        month = new JComboBox(months);
        year = new JComboBox(years);

        day.setBounds(290, 250, 80, 20);
        x.add(day);
        month.setBounds(380, 250, 80, 20);
        x.add(month);
        year.setBounds(470, 250, 80, 20);
        x.add(year);

        fc = new JLabel("FLIGHT CODE:");
        fc.setFont(new Font("Tahoma", Font.PLAIN, 20));
        fc.setBounds(60, 300, 200, 25);
        x.add(fc);

        t3 = new JTextField();
        t3.setBounds(290, 300, 150, 20);
        x.add(t3);

        c = new JButton("CANCEL");
        c.setBounds(290, 350, 100, 30);
        x.add(c);

        c.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent ae) {

                String PNR = t1.getText();
                String cancel = t2.getText();
                String fc = t3.getText();
                String d = day.getSelectedItem() +"-"+ month.getSelectedItem() +"-"+ year.getSelectedItem();


                try {
                    con c = new con();
                    String sr2 = "select PNR_NO, Flight_Code from reservation where Flight_Code = '"+d+"' and PNR_NO = '"+PNR+"'";
                    ResultSet rs2 = c.s.executeQuery(sr2);

                    if(rs2.next()) {
                        String sr = "select PNR_NO from cancellation where PNR_NO = '" + PNR + "'";
                        ResultSet rs = c.s.executeQuery(sr);
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Ticket with the given PNR NO: already cancelled");
                        } else {
                            String sr1 = "select PNR_NO, Flight_Code from reservation where Flight_Code = '" + d + "' and PNR_NO = '" + PNR + "'";
                            ResultSet rs1 = c.s.executeQuery(sr1);
                            if (rs1.next()) {
                                String str = "insert into cancellation values('" + PNR + "', '" + cancel + "', '" + d + "', '" + fc + "')";

                                c.s.executeUpdate(str);
                                JOptionPane.showMessageDialog(null, "Reservation Canceled");
                                setVisible(false);
                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No Ticket Booked with the Entered PNR NO");
                    }

                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        setSize(860, 500);
        setLocation(200, 50);
        setVisible(true);

    }

}
