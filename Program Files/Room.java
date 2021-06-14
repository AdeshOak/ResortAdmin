package Ass4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Room extends JFrame implements ActionListener {                                                     //Room class to store room data
    String room_type,room_status,occupancyStatus,cleaning_status,cust_name="";
    int room_no=0,cost,pax,occ_stat=1,room_stat=0,cleaning_stat=0,rt;

    JTextField roomno,roomType;
    JComboBox roomstatus,cleaningstatus;
    JButton b1,b2;

    public Room(){

        JLabel l1=new JLabel("Add Rooms");
        l1.setFont(new Font("Tahoma",Font.BOLD,17));
        l1.setBounds(200,20,100,20);
        add(l1);

        JLabel room=new JLabel("ROOM NO.");
        room.setFont(new Font("Tahoma",Font.PLAIN,17));
        room.setBounds(100,80,100,30);
        add(room);

        roomno=new JTextField();
        roomno.setBounds(220,80,150,30);
        add(roomno);

        JLabel roomtype=new JLabel("ROOM TYPE");
        roomtype.setFont(new Font("Tahoma",Font.PLAIN,17));
        roomtype.setBounds(100,130,100,30);
        add(roomtype);

        roomType=new JTextField();
        roomType.setBounds(220,130,150,30);
        add(roomType);


        JLabel roomStatus=new JLabel("ROOM STATUS");
        roomStatus.setFont(new Font("Tahoma",Font.PLAIN,17));
        roomStatus.setBounds(80,180,130,30);
        add(roomStatus);

        roomstatus=new JComboBox(new String[] {"Available","Unavailable"});
        roomstatus.setBounds(220,180,150,30);
        add(roomstatus);

        JLabel cleaningStatus=new JLabel("CLEANING STATUS");
        cleaningStatus.setFont(new Font("Tahoma",Font.PLAIN,17));
        cleaningStatus.setBounds(50,230,150,30);
        add(cleaningStatus);

        cleaningstatus=new JComboBox(new String[] {"Clean","Dirty"});
        cleaningstatus.setBounds(220,230,150,30);
        add(cleaningstatus);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        JLabel l2=new JLabel(i1);
        l2.setBounds(320,-130,450,600);
        add(l2);

        b1=new JButton("Add Room");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(50,280,150,30);
        add(b1);
        b2=new JButton("Cancel");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(220,280,150,30);
        add(b2);

        setBounds(450,200,750,470);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args){
        new Room().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            room_no=Integer.parseInt(roomno.getText());
            room_type=roomType.getText();
            if(room_type.equals("Basic")||room_type.equals("basic")){
                pax=2;
                cost=6000;
                rt=1;
            }
            else if(room_type.equals("Deluxe")||room_type.equals("deluxe")){
                pax=3;
                cost=8500;
                rt=2;
            }
            else if(room_type.equals("Suite")||room_type.equals("suite")){
                pax=4;
                cost=10000;
                rt=3;
            }
            room_status=roomstatus.getSelectedItem().toString();
            if(room_status.equalsIgnoreCase("Available")){
                room_stat=1;
            }
            cleaning_status=cleaningstatus.getSelectedItem().toString();
            if(cleaning_status.equalsIgnoreCase("Clean")){
                cleaning_stat=1;
            }
            if(occ_stat==1){
                occupancyStatus="Unoccupied";
            }
            else{
                occupancyStatus="Occupied";
            }
            Conn c=new Conn();
            String sql;
            sql = "INSERT INTO rooms VALUES (' "+room_no+" ',' "+room_type+" ','"+rt+"',' "+room_status+" ', '"+room_stat+"' ,' "+occupancyStatus+" ','"+occ_stat+"', ' "+cleaning_status+" ' ,'"+cleaning_stat+"','"+cust_name+"', ' "+pax+" ' , ' "+cost+" ' )" ;

            try {
                c.s.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Room Added to Database!");
                this.setVisible(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        else if(e.getSource()==b2){
            this.setVisible(false);
        }
    }
}
