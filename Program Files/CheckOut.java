package Ass4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CheckOut extends JFrame implements ActionListener {
    JTextField name,change,amt;
    JButton check,cout;
    int rem=0,dep,room,rno;
    String ps,cname;

    public CheckOut() {
    JLabel l1 = new JLabel("Check-Out Form");
        l1.setBounds(100,20,300,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new

    Font("Tahoma",Font.BOLD,17));

    add(l1);

    JLabel l2 = new JLabel("Room No.");
        l2.setBounds(35,80,100,20);
    add(l2);

    name=new JTextField();
    name.setBounds(180,80,150,20);
    add(name);

    check=new JButton("Check");
    check.setBounds(30,130,100,20);
    check.setForeground(Color.WHITE);
    check.setBackground(Color.BLUE);
    check.addActionListener(this);
    add(check);

        JLabel l8=new JLabel("Change Due ");
        l8.setBounds(30,180,180,20);
        add(l8);

        change=new JTextField();
        change.setBounds(180,180,150,20);
        add(change);

        JLabel l9=new JLabel("Amount Recieved");
        l9.setBounds(30,230,180,20);
        add(l9);

        amt=new JTextField();
        amt.setBounds(180,230,150,20);
        add(amt);


        cout=new JButton("Check Out");
        cout.setBounds(30,280,100,20);
        cout.setForeground(Color.WHITE);
        cout.setBackground(Color.BLUE);
        cout.addActionListener(this);
        add(cout);

        setLayout(null);
        setBounds(430,160,1000,640);
        setVisible(true);


}
public static void main(String[] args){
        new CheckOut().setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==check){
            rno=Integer.parseInt(name.getText());
            Conn c=new Conn();
            String sql="SELECT customer_name,assigned_room_no,deposit_paid,money_to_be_paid,payment_status FROM customers WHERE assigned_room_no='"+rno+"'";
            try{

                ResultSet rs=c.s.executeQuery(sql);
                while(rs.next()) {
                    cname = rs.getString("customer_name");
                    room = rs.getInt("assigned_room_no");
                    dep = rs.getInt("deposit_paid");
                    rem = rs.getInt("money_to_be_paid");
                    ps = rs.getString("payment_status");
                }

            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            change.setText(String.valueOf(rem));
        }
        if(e.getSource()==cout){
            Conn c=new Conn();
            int amtr=0;
            amtr=Integer.parseInt(amt.getText());
            System.out.println(rem+","+amtr);
            if(amtr < rem){
                amt.setText("");
                JOptionPane.showMessageDialog(null,"Insufficient change recieved!");
            }
            else if(amtr>=rem){
                rem=0;
                ps="Full Payment Done";
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                String outdate = formatter.format(date);
                String query1="UPDATE rooms SET occupancy_status='Unoccupied',occ_stat = 1,cleaning_status='Dirty',clean_stat=0,customer_name='' WHERE room_no='"+rno+"' ";
                String query3="UPDATE bookings SET check_out= '"+outdate+"' WHERE room_no='"+rno+"' ";
                String query="UPDATE customers SET money_to_be_paid=0,payment_status='Fully Paid' WHERE customer_name='"+cname+"'";
                try {
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query3);
                    c.s.executeUpdate(query);
                    TimeUnit.SECONDS.sleep(5);
                } catch (SQLException | InterruptedException throwables) {
                    throwables.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"Check-Out Successful!");
                this.setVisible(false);
            }


        }
    }
}
