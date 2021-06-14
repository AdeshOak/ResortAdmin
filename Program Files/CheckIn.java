package Ass4;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CheckIn extends JFrame implements ActionListener {

    JTextField name,aadhar,phone,rno,deposit,change;
    JComboBox rtype;
    JButton assign_room,checkin;
    int cost = 0,rn=0;

    public CheckIn(){
        JLabel l1=new JLabel("Check-In Form");
        l1.setBounds(100,20,300,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma",Font.BOLD,17));
        add(l1);

        JLabel l2=new JLabel("Customer Name");
        l2.setBounds(35,80,100,20);
        add(l2);

        name=new JTextField();
        name.setBounds(180,80,150,20);
        add(name);


        JLabel l3=new JLabel("Customer Phone");
        l3.setBounds(30,130,100,20);
        add(l3);

        phone=new JTextField();
        phone.setBounds(180,130,150,20);
        add(phone);

        JLabel l4=new JLabel("Customer Aadhar");
        l4.setBounds(30,180,100,20);
        add(l4);

        aadhar=new JTextField();
        aadhar.setBounds(180,180,150,20);
        add(aadhar);

        JLabel l5=new JLabel("Type of Room Booked");
        l5.setBounds(5,230,180,20);
        add(l5);

        rtype=new JComboBox(new String[] {"Basic","Deluxe","Suite"});
        rtype.setBounds(180,230,150,20);
        add(rtype);

        assign_room=new JButton("Assign Room");
        assign_room.setBounds(345,230,150,20);
        assign_room.setBackground(Color.BLUE);
        assign_room.setForeground(Color.WHITE);
        assign_room.addActionListener(this);
        add(assign_room);

        JLabel l6=new JLabel("Assigned Room No.");
        l6.setBounds(20,280,180,20);
        add(l6);
        rno=new JTextField();
        rno.setBounds(180,280,150,20);
        add(rno);

        JLabel l7=new JLabel("Enter Deposit Amount");
        l7.setBounds(5,330,180,20);
        add(l7);

        deposit=new JTextField();
        deposit.setBounds(180,330,150,20);
        add(deposit);

        JLabel l8=new JLabel("Amount Due ");
        l8.setBounds(30,380,180,20);
        add(l8);

        change=new JTextField();
        change.setBounds(180,380,150,20);
        add(change);

        checkin=new JButton("Check-In");
        checkin.setBounds(180,430,150,20);
        checkin.setBackground(Color.BLUE);
        checkin.setForeground(Color.WHITE);
        checkin.addActionListener(this);
        add(checkin);

        setLayout(null);
        setBounds(430,160,1000,640);
        setVisible(true);

    }

    public static void main(String[] args){
        new CheckIn().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==assign_room){
            int x=0;
            switch(rtype.getSelectedItem().toString()){
                case "Basic": x=1;
                break;
                case "Deluxe": x=2;
                break;
                case "Suite": x=3;
                break;
            }
            Conn c=new Conn();
            String sql="Select room_no , cost , rt , occ_stat , clean_stat  from rooms where rt ='"+x+"' and occ_stat = 1 and clean_stat=1";
            try {
                ResultSet rs=c.s.executeQuery(sql);
                while(rs.next()) {
                    rn = rs.getInt("room_no");
                    System.out.println(rn);
                    cost=rs.getInt("cost");
                }
                    if(rn!=0) {
                        rno.setText(String.valueOf(rn));
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Sorry No rooms available Currently!!");
                        new Reception().setVisible(true);
                        this.setVisible(false);
                    }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        else if(e.getSource()==checkin){
            int mtobepaid=0;
            String payment_status="";
            String check_in="",check_out="";
            if(aadhar.getText().length()<12){
                JOptionPane.showMessageDialog(null,"Please Enter a valid 12 digit Aadhar Number!!");
                aadhar.setText("");
            }
            if(phone.getText().length()<10){
                JOptionPane.showMessageDialog(null,"Please Enter a valid 10 digit Phone Number!!");
                phone.setText("");
            }

            String cname=name.getText();
            String aadh=aadhar.getText();
            String ph=phone.getText();
            String type=rtype.getSelectedItem().toString();
            int room_no=Integer.parseInt(rno.getText());
            int depo=Integer.parseInt(deposit.getText());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            check_in=formatter.format(date);


            if(depo < cost){
                mtobepaid = cost-depo;
                payment_status="Partial";
                change.setText(String.valueOf(mtobepaid));
            }
            else if(depo>=cost){
                mtobepaid=0;
                payment_status="Full Payment Done";
                change.setText(String.valueOf(mtobepaid));
            }
            Conn c=new Conn();
            String sql,sql1;
            sql = "UPDATE rooms set occupancy_status = 'Occupied' , customer_name = '"+cname+"',occ_stat = 0 where room_no = '"+room_no+" ' ";
            sql1 = "INSERT INTO customers VALUES (' "+cname+" ',' "+aadh+" ',' "+ph+" ',' "+type+" ',' "+room_no+" ', ' "+depo+" ' , ' "+mtobepaid+" ' , ' "+payment_status+" ' )" ;
            String query= "INSERT INTO bookings VALUES ('"+cname+"','"+ph+"','"+room_no+"','"+type+"','"+check_in+"','"+check_out+"')";
            try {
                c.s.executeUpdate(sql);
                c.s.executeUpdate(sql1);
                c.s.executeUpdate(query);
                TimeUnit.SECONDS.sleep(5);
            } catch (SQLException | InterruptedException throwables) {
                throwables.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,"Check-In Successful!");

            this.setVisible(false);
        }
    }
}
