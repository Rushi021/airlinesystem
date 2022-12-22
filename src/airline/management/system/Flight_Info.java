package airline.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Flight_Info extends JFrame {

    JTable table;
    private JTextField textField;

    public static void main (String [] args) {

        new Flight_Info().setVisible(true);
    }

    public Flight_Info() {

        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));

        Container r = getContentPane();
        r.setLayout(null);

        JLabel flightcode = new JLabel("FLIGHT_CODE");
        flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        flightcode.setBounds(50, 100, 200, 30);
        r.add(flightcode);

        textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
        r.add(textField);

        JLabel flightdetails = new JLabel("FLIGHT INFORMATION");
        flightdetails.setFont(new Font("Tahoma", Font.PLAIN, 30));
        flightdetails.setBounds(50, 20, 570, 35);
        r.add(flightdetails);

        JButton show = new JButton("SHOW");
        show.setFont(new Font("Tahoma", Font.PLAIN, 20));

        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String code = textField.getText();

                try {
                    con c1 = new con();

                    String str = "SELECT * FROM flight JOIN sector USING (Flight_Code) WHERE Flight_Code = '"+code+"'";


                    ResultSet rs = c1.s.executeQuery(str);
                    if(rs.next()) {
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Incorrect Flight Code!");
                    }

                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        show.setBounds(220, 150, 120, 30);
        r.add(show);

        table = new JTable();
        table.setBackground(Color.WHITE);
        table.setBounds(23, 250, 800, 300);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(23, 250, 800, 200);
        r.add(pane);

        JLabel flightCode = new JLabel("FLIGHT CODE");
        flightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
        flightCode.setBounds(50, 220, 126, 14);
        r.add(flightCode);

        JLabel flightname = new JLabel("FLIGHT NAME");
        flightname.setFont(new Font("Tahoma", Font.PLAIN, 13));
        flightname.setBounds(182,220,120,14);
        r.add(flightname);

        JLabel source = new JLabel("SOURCE");
        source.setFont(new Font("Tahoma", Font.PLAIN, 13));
        source.setBounds(320, 220,120,14);
        r.add(source);

        JLabel destination = new JLabel("DESTINATION");
        destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
        destination.setBounds(440, 220, 120, 14);
        r.add(destination);

        JLabel classcode = new JLabel("CLASS CODE");
        classcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
        classcode.setBounds(715, 220, 120, 14);
        r.add(classcode);

        JLabel classname = new JLabel("CLASS");
        classname.setFont(new Font("Tahoma", Font.PLAIN, 13));
        classname.setBounds(600, 220, 120, 14);
        r.add(classname);

        /*JLabel info = new JLabel("OVERALL INFO:");
        info.setFont(new Font("Tahoma", Font.PLAIN,15));
        info.setBounds(50, 200, 200, 25);
        r.add(info);*/

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(900, 550);
        setLocation(250, 50);
        setVisible(true);
    }
}
