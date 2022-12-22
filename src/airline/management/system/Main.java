package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import java.awt.Container;
import javax.swing.*;
import java.sql.*;

class Login extends JFrame implements ActionListener{

    JLabel l1, l2;
    JTextField t1, t2;
    JButton reset, submit, close, signup;
    Font f1, f2, f3, f4;
    JPasswordField p;
    JRadioButton show;

    Login () {
        super("Login");

        setBackground(Color.WHITE);
        setSize(400, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        f1 = new Font("TimesRoman", Font.BOLD, 15);
        f2 = new Font("TimeRoman", Font.BOLD,15);
        f3 = new Font("TimesRoman", Font.BOLD,12);
        f4 = new Font("TimesRoman", Font.BOLD,10);

        Container c = getContentPane();
        c.setLayout(null);

        l1 = new JLabel("Username:");
        l1.setBounds(20, 50, 100, 20);
        l1.setFont(f1);
        c.add(l1);

        t1 = new JTextField();
        t1.setBounds(130, 50, 100, 20);
        t1.setFont(f2);
        c.add(t1);

        l2 = new JLabel("Password:");
        l2.setBounds(20, 100, 100, 20);
        l2.setFont(f1);
        c.add(l2);

        p = new JPasswordField();
        p.setBounds(130, 100, 100, 20);
        p.setFont(f2);
        p.setEchoChar('*');
        c.add(p);

        show = new JRadioButton("show password");
        show.setBounds(125, 130, 130, 15);
        show.setFont(f4);
        c.add(show);

        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(show.isSelected()) {
                    p.setEchoChar((char)0);
                }
                else {
                    p.setEchoChar('*');
                }
            }
        });


        reset = new JButton("Reset");
        reset.setBounds(20, 160, 80, 20);
        reset.setFont(f3);
        c.add(reset);
        reset.addActionListener(this);

        submit = new JButton("Submit");
        submit.setBounds(130, 160, 80, 20);
        submit.setFont(f3);
        c.add(submit);
        submit.addActionListener(this);


        close = new JButton("Close");
        close.setBounds(240, 160, 80, 20);
        close.setFont(f3);
        c.add(close);
        close.addActionListener(this);

        signup = new JButton("Sign Up");
        signup.setBounds(130, 200, 80, 20);
        signup.setFont(f3);
        c.add(signup);
        signup.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent e) {
        if(e.getSource()==reset) {
              t1.setText("");
              p.setText("");
        }
        if(e.getSource() == close) {
            System.exit(0);
        }

        if(e.getSource() == submit) {
            try{
                con c = new con();

                String Username = t1.getText();
                String Password = p.getText();

                String str = "select * from login where Username = '"+Username+"' and Password = '"+Password+"'";
                ResultSet rs = c.s.executeQuery(str);

                if(rs.next()) {
                    new Mainframe();
                    setVisible(false);
                }
                else {
                   JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }catch (Exception ae) {}
        }
        if(e.getSource() == signup) {
            new register();
        }
        }

    }

public class Main {

    public static void main(String[] args) {

        Login l = new Login();
    }
}
