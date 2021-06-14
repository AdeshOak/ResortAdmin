package Ass4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu m1;
    JButton b1,b2;
    Dashboard(){
        mb=new JMenuBar();
        add(mb);

        m1=new JMenu("My Hotel Management System");
        mb.add(m1);

        b1=new JButton("Admin");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,60,120,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Reception");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(40,120,120,30);
        b2.addActionListener(this);
        add(b2);

        mb.setBounds(0,0,600,30);

        setLayout(null);
        setBounds(0,0,600,400);
        setVisible(true);


    }

    public static void main(String[] args){
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new Admin().setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
