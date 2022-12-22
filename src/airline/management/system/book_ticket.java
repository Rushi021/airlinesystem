package airline.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class book_ticket extends JFrame {

    public static void main(String [] args) {
        new book_ticket();
    }

    JLabel name, source, destination, date, number, ticket, detail, c, l1, l2;
    JTextField t1, t2, t3, t4;
    JComboBox day, month, year, src, dst, no, Class, t;
    JButton book;

    public book_ticket() {
        initialize();
    }

    private void initialize() {

        setTitle("BOOK TICKETS");
        setSize(1100, 700);
        getContentPane().setBackground(Color.WHITE);

        Container cc = getContentPane();
        cc.setLayout(null);

        detail = new JLabel("ENTER DETAILS");
        detail.setFont(new Font("Tahoma", Font.PLAIN,30));
        detail.setBounds(60, 40, 250, 30);
        add(detail);

        name = new JLabel("NAME:");
        name.setFont(new Font("Tahoma", Font.PLAIN,20));
        name.setBounds(60, 100, 100, 20);
        cc.add(name);

        t1 = new JTextField();
        t1.setBounds(290, 100, 100, 20);
        cc.add(t1);

        l2 = new JLabel("PNR NO:");
        l2.setFont(new Font("Tahoma", Font.PLAIN,20));
        l2.setBounds(60, 150, 100, 20);
        cc.add(l2);

        t4 = new JTextField();
        t4.setBounds(290, 150, 100, 20);
        cc.add(t4);

        ticket = new JLabel("TICKET ID:");
        ticket.setBounds(60, 200, 180, 20);
        ticket.setFont(new Font("Tahoma", Font.PLAIN,20));
        cc.add(ticket);

        t2 = new JTextField();
        t2.setBounds(290, 200, 100, 20);
        cc.add(t2);

        l1 = new JLabel("FLIGHT CODE:");
        l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        l1.setBounds(60, 250, 150, 20);
        cc.add(l1);

        t3 = new JTextField();
        t3.setBounds(290, 250, 100, 20);
        cc.add(t3);

        source = new JLabel("SOURCE:");
        source.setFont(new Font("Tahoma", Font.PLAIN,20));
        source.setBounds(60, 300, 100, 20);
        cc.add(source);

        destination = new JLabel("DESTINATION:");
        destination.setFont(new Font("Tahoma", Font.PLAIN,20));
        destination.setBounds(60, 350, 150, 20);
        cc.add(destination);

        String sr[] = {"MUMBAI", "DELHI", "GUJARAT", "HYDERABAD", "BANGALORE", "CHENNAI"};
        String dt[] = {"DELHI", "MUMBAI", "GUJARAT", "HYDERABAD", "BANGALORE", "CHENNAI"};

        src = new JComboBox(sr);
        src.setBounds(290, 300, 100, 20);
        cc.add(src);

        dst = new JComboBox(dt);
        dst.setBounds(290, 350, 100, 20);
        cc.add(dst);

        date = new JLabel("DATE:");
        date.setFont(new Font("Tahoma", Font.PLAIN,20));
        date.setBounds(60, 400, 100, 20);
        cc.add(date);

        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        String years[] = {"2002", "2003", "2004", "2005", "2006", "2007", "2008","2009", "2010","2011",
                "2012", "2013", "2014", "2015", "2016", "2018", "2019", "2020", "2021", "2022", "2023"};

        day = new JComboBox(days);
        day.setBounds(290, 400, 80, 20);
        cc.add(day);

        month = new JComboBox(months);
        month.setBounds(395, 400, 80, 20);
        cc.add(month);

        year = new JComboBox(years);
        year.setBounds(500, 400, 80, 20);
        cc.add(year);

        number = new JLabel("NO OF PASSENGERS:");
        number.setFont(new Font("Tahoma", Font.PLAIN,20));
        number.setBounds(60, 450, 200, 20);
        cc.add(number);

        String n[] = {"1", "2", "3", "4", "5", "6"};

        no = new JComboBox(n);
        no.setBounds(290, 450, 50, 20);
        cc.add(no);

        c = new JLabel("CLASS");
        c.setFont(new Font("Tahoma", Font.PLAIN,20));
        c.setBounds(60, 500, 100, 20);
        cc.add(c);

        String a[] = {"A", "B", "E", "S"};

        Class = new JComboBox(a);
        Class.setBounds(290, 500, 50, 20);
        cc.add(Class);

        JLabel time = new JLabel("JOURNEY TIME:");
        time.setFont(new Font("Tahoma", Font.PLAIN,20));
        time.setBounds(60, 550, 150, 20);
        cc.add(time);


        String x[] = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00",
        "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};

        t = new JComboBox(x);
        t.setBounds(290, 550, 100, 20);
        cc.add(t);

        JLabel view = new JLabel("ALL FLIGHTS");
        view.setFont(new Font("Tahoma", Font.PLAIN,23));
        view.setBounds(775, 50, 170, 25);
        cc.add(view);


        JTable table1 = new JTable();
        table1.setBounds(650, 120, 410, 370);
        cc.add(table1);

        try{
            con c = new con();

            String str3 = "select * from flight";

            ResultSet r3 = c.s.executeQuery(str3);
            table1.setModel(DbUtils.resultSetToTableModel(r3));

        }catch(SQLException e) {
            e.printStackTrace();
        }


        book = new JButton("BOOK");
        book.setBounds(290, 600, 100, 30);
        cc.add(book);

        book.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae) {

                String a1 = day.getSelectedItem() +"-"+ month.getSelectedItem() +"-"+ year.getSelectedItem();
                String s =  (String) src.getSelectedItem();
                String d = (String) dst.getSelectedItem();
                String p = (String) no.getSelectedItem();
                String c = (String) Class.getSelectedItem();
                String n = t1.getText();
                String id = t2.getText();
                String fc = t3.getText();
                String pnr = t4.getText();
                String tim = (String) t.getSelectedItem();

                try {
                    con c2 = new con();

                    String sr = "select PNR_NO from reservation where PNR_NO = '"+pnr+"'";
                    String sr1 = "select Ticket_Id from reservation where Ticket_Id = '"+id+"'";
                    String st2 = "select Name from passenger where Name = '"+n+"'";

                    ResultSet r2 = c2.s.executeQuery(st2);
                    if(r2.next()) {

                        ResultSet r = c2.s.executeQuery(sr);
                        if(r.next()) {
                            JOptionPane.showMessageDialog(null, "PNR NO Already Exits!");
                        }
                        ResultSet r1 = c2.s.executeQuery(sr1);
                        if(r1.next()){
                            JOptionPane.showMessageDialog(null, "Ticket Id Already Exists!");
                        }
                        else {
                            String str = "insert into reservation values('"+pnr+"', '"+n+"', '"+id+"', '"+fc+"', '"+a1+"', '"+tim+"', '"+s+"', '"+d+"','"+c+"', '"+p+"')";

                            c2.s.executeUpdate(str);
                            JOptionPane.showMessageDialog(null, "Ticket Booked");
                            setVisible(false);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "User Registration Required");
                    }

                }catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        setLocation(250, 50);
        setVisible(true);
    }
}
