package Ass4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {

    JLabel username,password;
    JTextField uname,pwd;
    JButton b1,b2;

    Login(){
        username=new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);
        password=new JLabel("Username");
        password.setBounds(40,70,100,30);
        add(password);
        uname=new JTextField();
        uname.setBounds(150,20,150,30);
        add(uname);
        pwd=new JPasswordField();
        pwd.setBounds(150,70,150,30);
        add(pwd);

        b1=new JButton("Login");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,150,120,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180,150,120,30);
        b2.addActionListener(this);
        add(b2);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/userIcon.png"));
        JLabel l3=new JLabel(i1);
        l3.setBounds(350,10,200,200);
        add(l3);

        getContentPane().setBackground(Color.WHITE);


    setLayout(null);
        setBounds(500,300,600,400);
        setVisible(true);
    }

    public static void main(String[] args){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            String username=uname.getText();
            String password=pwd.getText();
            if(username.equals("admin") && password.equals("admin")){
                //JOptionPane.showMessageDialog(null,"Correct username or password");
                new Dashboard().setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    this.setVisible(false);
                }

        }else if(e.getSource()==b2){
            System.exit(0);
        }
    }
}
