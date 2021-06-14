package Ass4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;

    public Admin(){

        mb=new JMenuBar();
        add(mb);

        m1=new JMenu("My Hotel Management System");
        m1.setForeground(Color.BLUE);
        mb.add(m1);

        m2=new JMenu("Admin");
        m2.setForeground(Color.BLUE);
        mb.add(m2);

        i4=new JMenuItem("Back to DashBoard");
        i4.addActionListener(this);
        m1.add(i4);

        i1=new JMenuItem("Add Rooms");
        i1.addActionListener(this);
        m2.add(i1);

        i2=new JMenuItem("Add Employees");
        i2.addActionListener(this);
        m2.add(i2);

        i3=new JMenuItem("View Bookings");
        i3.addActionListener(this);
        m2.add(i3);

        mb.setBounds(0,0,1950,30);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/hotel1.jpg"));
        Image i2=i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(0,0,1950,1010);
        add(l1);

        JLabel l2=new JLabel("Welcome Admin");
        l2.setBounds(700,50,600,50);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,50));
        l1.add(l2);



        setLayout(null);
        setBounds(0,0,1950,1000);
        setVisible(true);

    }

    public static void main(String[] args){
       new Admin().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Employees")){
            new Employee().setVisible(true);
        }
        else if(e.getActionCommand().equals("Add Rooms")){
            new Room().setVisible(true);
        }
        else if(e.getActionCommand().equals("View Bookings")){
            new Bookings().setVisible(true);
        }
        else if(e.getActionCommand().equals("Back to DashBoard")){
            new Dashboard().setVisible(true);
            this.setVisible(false);
        }
    }
}
