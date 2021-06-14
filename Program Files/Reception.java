package Ass4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu m1, m2;
    JMenuItem i1, i2, i3, i4,i5,i6,i7;

    Reception() {
        mb = new JMenuBar();
        add(mb);

        m1 = new JMenu("My Hotel Management System");
        m1.setForeground(Color.BLUE);
        mb.add(m1);

        m2 = new JMenu("Reception");
        m2.setForeground(Color.BLUE);
        mb.add(m2);
        i6=new JMenuItem("Back to DashBoard");
        i6.addActionListener(this);
        m1.add(i6);

        i1 = new JMenuItem("Check-In");
        i1.addActionListener(this);
        m2.add(i1);

        i2 = new JMenuItem("View Rooms");
        i2.addActionListener(this);
        m2.add(i2);

        i3 = new JMenuItem("Check Out");
        i3.addActionListener(this);
        m2.add(i3);
        i4 = new JMenuItem("View Customers");
        i4.addActionListener(this);
        m2.add(i4);

        i5 = new JMenuItem("View Employees");
        i5.addActionListener(this);
        m2.add(i5);

        i7=new JMenuItem("Update Room Cleaning Status");
        i7.addActionListener(this);
        m2.add(i7);


        mb.setBounds(0, 0, 1950, 30);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1950, 1010);
        add(l1);

        JLabel l2 = new JLabel("Welcome Reception");
        l2.setBounds(720, 50, 600, 50);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 50));
        l1.add(l2);


        setLayout(null);
        setBounds(0, 0, 1950, 1000);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Reception().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("View Employees")){
            new EmployeeInfo().setVisible(true);
        }
        else if(e.getActionCommand().equals("View Rooms")){
            new RoomInfo().setVisible(true);
        }
        else if(e.getActionCommand().equals("View Customers")){
            new CustomerInfo().setVisible(true);
        }
        else if(e.getActionCommand().equals("Check-In")){
            new CheckIn().setVisible(true);
        }
        else if(e.getActionCommand().equals("Check Out")){
            new CheckOut().setVisible(true);
        }
        else if(e.getActionCommand().equals("Back to DashBoard")){
            new Dashboard().setVisible(true);
            this.setVisible(false);
        }
        else if(e.getActionCommand().equals("Update Room Cleaning Status")){
            new URCstatus().setVisible(true);
        }
    }
}
