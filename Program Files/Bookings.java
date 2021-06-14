package Ass4;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bookings extends JFrame implements ActionListener {                 //Bookings class to store bookings data which can be viewable in admin menu

    String cname="",cphone="",room_type="";
    int room_no=0;
    String check_in="",check_out="";

    JTable t1;
    JButton b1,b2;

    public Bookings(){                 //Default constructor
        t1=new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);

        b1=new JButton("Load Bookings");
        b1.setBounds(350,560,150,30);
        b1.addActionListener(this);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLUE);
        add(b1);

        b2=new JButton("Back");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(530,560,120,30);
        b2.addActionListener(this);
        add(b2);

    JLabel roomno=new JLabel("Customer Name");
        roomno.setBounds(40,10,90,20);
    add(roomno);

    JLabel type=new JLabel("Customer Phone");
        type.setBounds(195,10,130,20);
    add(type);

    JLabel status=new JLabel("Room No.");
        status.setBounds(380,10,90,20);
    add(status);

    JLabel cstatus=new JLabel("Room Type");
        cstatus.setBounds(520,10,90,20);
    add(cstatus);

    JLabel ostatus=new JLabel("Check In");
        ostatus.setBounds(680,10,120,20);
    add(ostatus);

    JLabel cname=new JLabel("Check Out");
        cname.setBounds(880,10,90,20);
    add(cname);


    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(430,160,1000,640);
    setVisible(true);
    }


    public static void main(String[] args){
        new Bookings().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            Conn c=new Conn();
            String sql="SELECT customer_name, customer_phone, room_no, room_type, check_in, check_out FROM bookings";

            try {
                ResultSet rs=c.s.executeQuery(sql);

                t1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else if(e.getSource()==b2){
            this.setVisible(false);
        }
    }
}

