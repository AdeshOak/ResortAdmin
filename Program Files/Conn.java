package Ass4;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            c = DriverManager.getConnection("jdbc:mysql://localhost/resort","root","adroot");
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
