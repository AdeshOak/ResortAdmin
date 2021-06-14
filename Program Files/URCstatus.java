package Ass4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class URCstatus extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu m1;
    JButton b1,b2;
    JTextField rn,rcs;
    int no=0;
    String cleaning_status;

    public URCstatus(){
        mb=new JMenuBar();
        add(mb);

        m1=new JMenu("My Hotel Management System");
        mb.add(m1);

        JLabel l1=new JLabel("Enter Room No.");
        l1.setBounds(40,60,120,30);
        add(l1);



        rn=new JTextField();
        rn.setBounds(150,60,120,30);
        add(rn);


        b2=new JButton("Check Cleaning Status");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(40,110,180,30);
        b2.addActionListener(this);
        add(b2);

        JLabel l2=new JLabel("Current Cleaning Status");
        l2.setBounds(10,160,150,30);
        add(l2);


        rcs= new JTextField();
        rcs.setBounds(150,160,120,30);
        add(rcs);
        b1=new JButton("Update Cleaning Status");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,210,180,30);
        b1.addActionListener(this);
        add(b1);

        mb.setBounds(0,0,600,30);

        setLayout(null);
        setBounds(480,160,600,400);
        setVisible(true);
    }
    public static void main(String[] args){
        new URCstatus().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==b2){
        no=Integer.parseInt(rn.getText());
        Conn c=new Conn();
        String sql="Select room_no,cleaning_status,clean_stat from rooms where room_no = '"+no+"'";
        try {
            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()){
                int room=rs.getInt("room_no");
                cleaning_status=rs.getString("cleaning_status");
                int x=rs.getInt("clean_stat");
                rcs.setText(cleaning_status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    if(e.getSource()==b1){
        String sql="";
        Conn c=new Conn();
        if(cleaning_status.equals("Dirty")){
            sql="UPDATE rooms SET cleaning_status='Clean' , clean_stat=1 WHERE room_no='" + no + "'";
        }
        else if(cleaning_status.equals("Clean")){
            sql="UPDATE rooms SET cleaning_status='Dirty' , clean_stat=0 WHERE room_no='" + no + "'";
        }
        try {
            c.s.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Cleaning Status Updated Successfully!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.setVisible(false);
    }
    }
}
