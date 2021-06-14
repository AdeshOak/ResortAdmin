package Ass4;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1,b2;
    RoomInfo(){
        t1=new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);

        b1=new JButton("Load Rooms");
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

        JLabel roomno=new JLabel("Room No.");
        roomno.setBounds(40,10,90,20);
        add(roomno);

        JLabel type=new JLabel("Room Type");
        type.setBounds(175,10,90,20);
        add(type);

        JLabel status=new JLabel("Room Status");
        status.setBounds(320,10,90,20);
        add(status);

        JLabel cstatus=new JLabel("Cleaning Status");
        cstatus.setBounds(450,10,90,20);
        add(cstatus);

        JLabel ostatus=new JLabel("Occupancy Status");
        ostatus.setBounds(580,10,120,20);
        add(ostatus);

        JLabel cname=new JLabel("Customer Name");
        cname.setBounds(740,10,90,20);
        add(cname);

        JLabel cost=new JLabel("Cost ( ₹ )");
        cost.setBounds(870,10,90,20);
        add(cost);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(430,160,1000,640);
        setVisible(true);

    }

    public static void main(String[] args){
        new RoomInfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            Conn c=new Conn();
            String sql="SELECT room_no, room_type, room_status, cleaning_status, occupancy_status, customer_name,cost FROM rooms";

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

