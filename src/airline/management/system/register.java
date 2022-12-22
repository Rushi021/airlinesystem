package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class register extends JFrame {

    public register() {
        initialize();
    }

    JLabel user, pass, l1;
    JTextField t1, t2;
    JButton register;

    private void initialize() {
        setTitle("SIGN UP");
        getContentPane().setBackground(Color.WHITE);
        setSize(420, 320);
        setLayout(null);
        setLocationRelativeTo(null);

        l1 = new JLabel("SIGNUP");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l1.setBounds(50, 30, 200, 30);
        add(l1);

        user = new JLabel("Enter Username:");
        user.setFont(new Font("Tahoma", Font.PLAIN, 15));
        user.setBounds(50, 100, 200, 20);
        add(user);

        t1 = new JTextField();
        t1.setBounds(220, 100, 100, 20);
        add(t1);

        pass = new JLabel("Enter Password:");
        pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pass.setBounds(50, 150, 200, 20);
        add(pass);

        t2 = new JPasswordField();
        t2.setBounds(220, 150, 100, 20);
        add(t2);

        register = new JButton("Sign Up");
        register.setBounds(220,200,100,20);
        add(register);

        register.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                try{
                    con c = new con();

                    String username = t1.getText();
                    String password = t2.getText();

                    String str = "insert into login values('"+username+"', '"+password+"')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Login SuccessFull!");
                }catch(Exception ae) {
                    ae.printStackTrace();
                }
            }
        });


        setVisible(true);
    }
}
