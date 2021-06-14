package Ass4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;

    EmployeeInfo(){

        t1=new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);

        b1=new JButton("Load Employees");
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

        JLabel name=new JLabel("Employee Name");
        name.setBounds(20,10,90,20);
        add(name);

        JLabel age=new JLabel("Employee Age");
        age.setBounds(160,10,90,20);
        add(age);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(310,10,90,20);
        add(gender);

        JLabel jd=new JLabel("Job Description");
        jd.setBounds(450,10,90,20);
        add(jd);

        JLabel pn=new JLabel("Phone No.");
        pn.setBounds(610,10,90,20);
        add(pn);

        JLabel aadh=new JLabel("Aadhar No.");
        aadh.setBounds(755,10,90,20);
        add(aadh);

        JLabel sal=new JLabel("Salary ( ₹ )");
        sal.setBounds(880,10,90,20);
        add(sal);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(430,160,1000,640);
        setVisible(true);
    }

    public static void main(String[] args){
    new EmployeeInfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){

            Conn c=new Conn();
            String sql="Select * from employees";

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
