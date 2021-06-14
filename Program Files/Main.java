package Ass4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import java.util.concurrent.TimeUnit;
import java.sql.*;
import java.awt.event.*;


public class Main extends JFrame implements ActionListener {


    Main() {
        //JFrame img=new JFrame("intro");

        setBounds(300, 300, 1368, 768);
        //setSize(400,400);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
        JLabel l1 = new JLabel();
        l1.setIcon(i1);
        l1.setBounds(0, 0, 1368, 768);
        add(l1);

        JLabel l2 = new JLabel("My Hotel Management System");
        l2.setBounds(20, 600, 1000, 70);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("serif", Font.PLAIN, 60));
        l1.add(l2);

        JButton b1 = new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(1040, 620, 200, 50);
        l1.add(b1);
        b1.addActionListener(this);
        setLayout(null);
        setVisible(true);

        while (true) {
            l2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            l2.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Login().setVisible(true);
        this.setVisible(false);
    }


    public static void main(String[] args) throws InterruptedException {    //main function
        new Main();

    }
}