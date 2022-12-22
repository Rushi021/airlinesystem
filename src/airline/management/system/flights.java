package airline.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class flights extends JFrame {
    public static void main(String [] args) {
        new flights();
    }

    JLabel view;
    JLabel l1, l2, l3, l4;
    JButton show;
    JTable table;

    public flights() {
        initialize();
    }

    private void initialize() {
        setTitle("ALL FLIGHTS");
        setSize(700,600);
        getContentPane().setBackground(Color.WHITE);

        Container s = getContentPane();
        s.setLayout(null);

        view = new JLabel("VIEW ALL FLIGHTS");
        view.setFont(new Font("Tahoma", Font.PLAIN,30));
        view.setBounds(195, 50, 400, 35);
        s.add(view);

        show = new JButton("SHOW");
        show.setBounds(270, 120, 100, 35);
        s.add(show);

        l1 = new JLabel("FLIGHT CODE");
        l1.setFont(new Font("Tahoma", Font.PLAIN,15));
        l1.setBounds(60, 200, 150, 17);
        s.add(l1);

        l2 = new JLabel("FLIGHT NAME");
        l2.setFont(new Font("Tahoma", Font.PLAIN,15));
        l2.setBounds(200, 200, 150, 17);
        s.add(l2);

        l3 = new JLabel("SOURCE");
        l3.setFont(new Font("Tahoma", Font.PLAIN,15));
        l3.setBounds(340, 200, 100, 17);
        s.add(l3);

        l4 = new JLabel("DESTINATION");
        l4.setFont(new Font("Tahoma", Font.PLAIN,15));
        l4.setBounds(470, 200, 150, 17);
        s.add(l4);

        table = new JTable();
        table.setBounds(55, 230, 530, 200);
        s.add(table);

        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {


                try {
                    con c = new con();

                    String str = "select * from flight";

                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        setLocation(250,100);
        setVisible(true);
    }
}
