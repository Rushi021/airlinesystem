package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Add_Customer extends JFrame {

    JLabel PNR, name, gender, nationality,passport, phone_no, address, fc;
    JTextField t1, t2, t3, t4, t5, t6;
    JTextArea ta1;
    JRadioButton male, female;
    JButton save;

    public Add_Customer () {
        getContentPane().setForeground(Color.BLUE);
        setTitle("ADD PASSENGER DETAILS");


        Container a = getContentPane();
        a.setLayout(null);


        PNR = new JLabel("PNR NO:");
        PNR.setFont(new Font("Tahoma", Font.PLAIN, 17));
        PNR.setBounds(60, 80, 150, 27);
        a.add(PNR);

        t1 = new JTextField();
        t1.setBounds(210,80,150,27);
        a.add(t1);

        name = new JLabel("NAME:");
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setBounds(60, 120, 150, 27);
        a.add(name);

        t2 = new JTextField();
        t2.setBounds(210, 120, 150, 27);
        a.add(t2);

        gender = new JLabel("GENDER:");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        gender.setBounds(60, 160, 150, 27);
        a.add(gender);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        /*male.setFont(new Font("Tahoma", Font.PLAIN, 17));
        female.setFont(new Font("Tahoma", Font.PLAIN, 17)); */
        male.setSelected(true);
        male.setBounds(210, 160, 100, 27);
        female.setBounds(320, 160, 100, 27);
        a.add(male);
        a.add(female);

        ButtonGroup g = new ButtonGroup();
        g.add(male);
        g.add(female);

        nationality = new JLabel("NATIONALITY:");
        nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        nationality.setBounds(60, 200, 150, 27);
        a.add(nationality);

        t3 = new JTextField();
        t3.setBounds(210, 200, 150, 27);
        a.add(t3);

        passport = new JLabel("PASSPORT NO:");
        passport.setFont(new Font("Tahoma", Font.PLAIN, 17));
        passport.setBounds(60, 240, 150, 27);
        a.add(passport);

        t4 = new JTextField();
        t4.setBounds(210, 240, 150, 27);
        a.add(t4);

        phone_no = new JLabel("PHONE NO:");
        phone_no.setFont(new Font("Tahoma", Font.PLAIN, 17));
        phone_no.setBounds(60, 280, 150, 27);
        a.add(phone_no);

        t5 = new JTextField();
        t5.setBounds(210, 280, 150, 27);
        a.add(t5);

        address = new JLabel("ADDRESS:");
        address.setFont(new Font("Tahoma", Font.PLAIN,17));
        address.setBounds(60, 320, 150, 27);
        a.add(address);

        ta1 = new JTextArea();
        ta1.setBounds(210, 320, 150, 50);
        a.add(ta1);

        fc = new JLabel("FLIGHT CODE:");
        fc.setFont(new Font("Tahoma", Font.PLAIN,17));
        fc.setBounds(60, 383, 150, 27);
        a.add(fc);

        t6 = new JTextField();
        t6.setBounds(210, 383, 150, 27);
        a.add(t6);

        save = new JButton("SAVE");
        save.setBounds(210, 423, 100, 27);
        a.add(save);

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String PNR = t1.getText();
                String name = t2.getText();
                String gender = "Male";
                if(female.isSelected()) {
                    gender = "Female";
                }

                String nationality = t3.getText();
                String passport = t4.getText();
                String phone_no = t5.getText();
                String address = ta1.getText();
                String  fc = t6.getText();

                try {
                    con c = new con();
                    String sr = "select PNR_NO from passenger where PNR_NO = '"+PNR+"'";
                    String str = "insert into passenger values( '"+PNR+"', '"+name+"', '"+gender+"', '"+nationality+"', '"+passport+"', '"+phone_no+"', '"+address+"', '"+fc+"')";

                    ResultSet rs = c.s.executeQuery(sr);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "PNR already exists!");
                    }
                    else{
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null, "Customer Added!");
                        setVisible(false);
                    }

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocation(250, 50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Add_Customer();
    }
}


