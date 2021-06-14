package Ass4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee extends JFrame implements ActionListener {                                                                //Employee class to store employee information
    String e_name,e_phone,e_aadhar,e_job_desc;
    int e_age,e_salary;
    char e_gender;

    JTextField empname,empPhone,empAadhar,empage,empsalary;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;

    Employee(){
        JLabel name=new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,30,120,30);
        add(name);

        empname=new JTextField();
        empname.setBounds(200,30,150,30);
        add(empname);

        JLabel age=new JLabel("AGE");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,80,120,30);
        add(age);

        empage=new JTextField();
        empage.setBounds(200,80,150,30);
        add(empage);

        JLabel phone=new JLabel("PHONE");
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        phone.setBounds(60,130,120,30);
        add(phone);

        empPhone=new JTextField();
        empPhone.setBounds(200,130,150,30);
        add(empPhone);

        JLabel aadhar=new JLabel("AADHAR NO.");
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        aadhar.setBounds(60,180,120,30);
        add(aadhar);

        empAadhar=new JTextField();
        empAadhar.setBounds(200,180,150,30);
        add(empAadhar);

        JLabel gender=new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,230,120,30);
        add(gender);

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.PLAIN,14));
        r1.setBounds(200,230,70,30);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.PLAIN,14));
        r2.setBounds(280,230,70,30);
        r2.setBackground(Color.WHITE);
        add(r2);

        JLabel job=new JLabel("JOB DESCRIPTION");
        job.setFont(new Font("Tahoma",Font.PLAIN,16));
        job.setBounds(30,280,140,30);
        add(job);

        String[] str={"Receptionist","Room Service","Kitchen Staff","Operations Manager","Accountant","Waiter","Porters"};
        c1=new JComboBox(str);
        c1.setBounds(200,280,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel salary=new JLabel("SALARY");
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        salary.setBounds(60,330,130,30);
        add(salary);

        empsalary=new JTextField();
        empsalary.setBounds(200,330,150,30);
        add(empsalary);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/staff.jpg"));
        JLabel l1=new JLabel(i1);
        l1.setBounds(240,-60,500,500);
        add(l1);

        JLabel l2=new JLabel("Add Employee Details");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,17));
        l2.setBounds(430,30,400,30);
        add(l2);

        b1=new JButton("Submit");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLUE);
        b1.setBounds(200,380,150,30);
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(540,200,700,550);
        setVisible(true);

    }

    public static void main(String[] args){
        new Employee().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        e_name=empname.getText();
        e_age=Integer.parseInt(empage.getText());
        e_phone=empPhone.getText();
        e_aadhar=empAadhar.getText();
        if(r1.isSelected()){
            e_gender='M';
        }
        else if(r2.isSelected()){
            e_gender='F';
        }
        e_job_desc=c1.getSelectedItem().toString();
        e_salary=Integer.parseInt(empsalary.getText());

        Conn c=new Conn();

        String sql;
        sql = "INSERT INTO employees VALUES (' "+e_name+" ',' "+e_age+" ',' "+e_gender+" ',' "+e_job_desc+" ',' "+e_phone+" ', ' "+e_aadhar+" ' , ' "+e_salary+" ' )" ;


        try {
            c.s.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"New Employee Added!");
            this.setVisible(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}