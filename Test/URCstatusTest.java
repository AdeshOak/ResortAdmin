package Ass4;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class URCstatusTest {

    @Test
    public void testUpdate() throws InterruptedException {
        URCstatus u=new URCstatus();
        String init="";
        u.rn.setText("103");
        u.no=Integer.parseInt(u.rn.getText());
        u.b2.doClick();
        Conn c=new Conn();
        String sql="Select room_no,cleaning_status,clean_stat from rooms where room_no = '"+u.no+"'";
        try {
            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()){
                int room=rs.getInt("room_no");
                u.cleaning_status=rs.getString("cleaning_status");
                int x=rs.getInt("clean_stat");
                u.rcs.setText(u.cleaning_status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        init=u.cleaning_status;
        u.b2.doClick();

        String cs="";
        String sql1="Select room_no,cleaning_status,clean_stat from rooms where room_no = '"+u.no+"'";
        try {
            ResultSet rs=c.s.executeQuery(sql1);
            while(rs.next()){
                cs=rs.getString("cleaning_status");
                int x=rs.getInt("clean_stat");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assertNotEquals(cs,init,"Cleaning status not updated !!\nTEST CASE FAILED XXX\n");
        Thread.sleep(2000);
    }

}