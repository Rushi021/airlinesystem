package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mainframe extends JFrame {
    public static void main(String [] args) {
        new Mainframe().setVisible(true);
    }

    public Mainframe () {
        super("AIRLINE MANAGEMENT SYSTEM");
        initialize();
    }

    private void initialize () {

        setForeground(Color.CYAN);
        setLayout(null);

        Container cc = getContentPane();
        cc.setLayout(null);

        JLabel NewLabel = new JLabel("");
        NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/web.jpg")));
        NewLabel.setBounds(0, 0, 1720, 790);
        cc.add(NewLabel);

        JLabel ams  = new JLabel("WELCOME TO AIRLINE RESERVATION SYSTEM");
        ams.setForeground(Color.BLUE);
        ams.setFont(new Font("Tahoma", Font.PLAIN, 35));
        ams.setBounds(400, 40, 1000, 55);
        add(ams);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu AirlineSystem = new JMenu("AIRLINE SYSTEM");
        AirlineSystem.setForeground(Color.BLUE);
        menuBar.add(AirlineSystem);

        JMenuItem FlightDetails = new JMenuItem("FLIGHT INFO");
        AirlineSystem.add(FlightDetails);

        JMenuItem ReservationDetails = new JMenuItem("ADD CUSTOMER DETAILS");
        AirlineSystem.add(ReservationDetails);

        JMenuItem PassengerDetails = new JMenuItem("JOURNEY DETAILS");
        AirlineSystem.add(PassengerDetails);

        JMenuItem SectorDetails = new JMenuItem("PAYMENT DETAILS");
        AirlineSystem.add(SectorDetails);

        JMenuItem Cancellation = new JMenuItem("CANCELLATION");
        AirlineSystem.add(Cancellation);

        JMenu Ticket = new JMenu("TICKET");
        Ticket.setForeground(Color.RED);
        menuBar.add(Ticket);

        JMenuItem book = new JMenuItem("BOOK TICKET");
        Ticket.add(book);

        JMenuItem view = new JMenuItem("TICKET OVERVIEW");
        Ticket.add(view);

        JMenu List = new JMenu("LIST");
        List.setForeground(Color.BLUE);
        menuBar.add(List);

        JMenuItem select = new JMenuItem("FLIGHTS");
        List.add(select);

        JMenuItem customer = new JMenuItem("PASSENGERS");
        List.add(customer);


        FlightDetails.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae) {
                new Flight_Info();
            }
        });

        ReservationDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Add_Customer();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        PassengerDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Journey_Details();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        SectorDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Payment_details();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Cancellation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new cancel();
            }
        });

        book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new book_ticket();
            }
        });

        view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new overview();
            }
        });

        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new flights();
            }
        });

        customer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CustomerDetails();
            }
        });

        setSize(1950, 1090);
        setLocation(0, 0);
        setVisible(true);
    }
}
