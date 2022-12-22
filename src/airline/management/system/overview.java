package airline.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class overview extends JFrame {

    public static void main(String [] args) {

        new overview();
    }

    JLabel date, name, title;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1;
    JComboBox day, month, year;
    JButton show;
    JTable table;

    public overview() {
        initialize();
    }

    private void initialize() {

        setTitle("VIEW");
        getContentPane().setBackground(Color.WHITE);
        setSize(1190, 600);

        Container r = getContentPane();
        r.setLayout(null);

        title = new JLabel("TICKET OVERVIEW");
        title.setFont(new Font("Tahoma", Font.PLAIN,30));
        title.setBounds(60, 50, 350, 30);
        r.add(title);


        name = new JLabel("NAME:");
        name.setFont(new Font("Tahoma", Font.PLAIN,17));
        name.setBounds(60, 150, 100, 20);
        r.add(name);

        t1 = new JTextField();
        t1.setBounds(230, 150, 100, 20);
        r.add(t1);

        date = new JLabel("JOURNEY DATE");
        date.setFont(new Font("Tahoma", Font.PLAIN, 17));
        date.setBounds(60, 200, 200,20);
        r.add(date);

        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        String years[] = {"2002", "2003", "2004", "2005", "2006", "2007", "2008","2009", "2010","2011",
                "2012", "2013", "2014", "2015", "2016", "2018", "2019", "2020", "2021", "2022", "2023"};

        day = new JComboBox(days);
        day.setBounds(230, 200, 80, 20);
        r.add(day);

        month = new JComboBox(months);
        month.setBounds(320, 200, 80, 20);
        r.add(month);

        year = new JComboBox(years);
        year.setBounds(410, 200, 80, 20);
        r.add(year);

        show = new JButton("VIEW");
        show.setBounds(230, 250, 100, 20);
        r.add(show);

        table = new JTable();
        table.setBounds(55, 350, 1050, 200);
        r.add(table);

        JLabel l9 = new JLabel("PNR NO");
        l9.setBounds(70, 320, 100, 15);
        l9.setFont(new Font("Tahoma", Font.PLAIN,12));
        r.add(l9);

        l1 = new JLabel("NAME");
        l1.setFont(new Font("Tahoma", Font.PLAIN,12));
        l1.setBounds(180, 320, 100, 15);
        r.add(l1);

        l2 = new JLabel("TICKET ID");
        l2.setFont(new Font("Tahoma", Font.PLAIN,12));
        l2.setBounds(280, 320, 150, 15);
        r.add(l2);

        JLabel l8 = new JLabel("FLIGHT CODE");
        l8.setFont(new Font("Tahoma", Font.PLAIN,12));
        l8.setBounds(380, 320, 100, 15);
        r.add(l8);

        JLabel l = new JLabel("TIME");
        l.setFont(new Font("Tahoma", Font.PLAIN,12));
        l.setBounds(610, 320, 100, 15);
        r.add(l);

        l3 = new JLabel("SOURCE");
        l3.setBounds(703, 320, 100, 15);
        l3.setFont(new Font("Tahoma", Font.PLAIN,12));
        r.add(l3);

        l4 = new JLabel("DESTINATION");
        l4.setFont(new Font("Tahoma", Font.PLAIN,12));
        l4.setBounds(800, 320, 150, 15);
        r.add(l4);

        l5 = new JLabel("JOURNEY DATE");
        l5.setFont(new Font("Tahoma", Font.PLAIN,12));
        l5.setBounds(480, 320, 150, 15);
        r.add(l5);

        l6 = new JLabel("NO OF PASSENGER");
        l6.setFont(new Font("Tahoma", Font.PLAIN,12));
        l6.setBounds(1000, 320, 170, 15);
        r.add(l6);

        l7 = new JLabel("CLASS");
        l7.setFont(new Font("Tahoma", Font.PLAIN,12));
        l7.setBounds(925, 320, 100, 15);
        r.add(l7);





        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String nam = t1.getText();
                String n = day.getSelectedItem() +"-"+ month.getSelectedItem() +"-"+ year.getSelectedItem();

                try {
                    con a = new con();

                    String s = "select Name, Journey_Date from reservation where Name = '"+nam+"' and Journey_Date = '"+n+"'";
                    ResultSet r = a.s.executeQuery(s);


                    if(r.next()){
                        String str = "select * from reservation where Name = '"+nam+"' and Journey_Date = '"+n+"'";

                        ResultSet rs = a.s.executeQuery(str);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect Name or Journey date");
                    }


                }catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        setLocation(250, 100);
        setVisible(true);
    }
}
