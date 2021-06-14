package Ass4;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;
    CustomerInfo(){
        t1=new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);

        b1=new JButton("Load Customers");
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

        JLabel name=new JLabel("Customer Name");
        name.setBounds(17,10,90,20);
        add(name);

        JLabel aadhar=new JLabel("Customer Aadhar");
        aadhar.setBounds(135,10,110,20);
        add(aadhar);

        JLabel phone=new JLabel("Customer Phone");
        phone.setBounds(260,10,110,20);
        add(phone);

        JLabel rtype=new JLabel("Room Type");
        rtype.setBounds(400,10,90,20);
        add(rtype);

        JLabel rn=new JLabel("Room No.");
        rn.setBounds(530,10,90,20);
        add(rn);

        JLabel d=new JLabel("Deposit ( ₹ )");
        d.setBounds(655,10,90,20);
        add(d);

        JLabel rem=new JLabel("Amount Due ( ₹ )");
        rem.setBounds(760,10,120,20);
        add(rem);

        JLabel ps=new JLabel("Payment Status");
        ps.setBounds(880,10,90,20);
        add(ps);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(430,160,1000,640);
        setVisible(true);
    }

    public static void main(String[] args){
        new CustomerInfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){

            Conn c=new Conn();
            String sql;
            sql="SELECT customer_name,aadhar,phone,booked_room_type,assigned_room_no,deposit_paid,money_to_be_paid,payment_status FROM customers";


            try {
                ResultSet rs=c.s.executeQuery(sql);

                t1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else if(e.getSource()==b2){
            this.setVisible(false);
        }
    }

}
