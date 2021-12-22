package Ass4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {


    @Test
    public void existingRoom() throws InterruptedException {
        int rno=101;
        System.out.println("---TEST CASE 6---\nRoom no: 101\nType:Deluxe\n-----------------");
        Room r1=new Room();
        r1.roomno.setText(String.valueOf(rno));
        r1.roomType.setText("Deluxe");
        r1.b1.doClick();
        System.out.println(r1.message);
        assertTrue(r1.room_no==rno);
        //assertEquals(1,r1.flag);
        Thread.sleep(20000);

    }

    @Test
    public void newRoom() throws InterruptedException {
        int rno=101;
        System.out.println("---TEST CASE 5---\nRoom no: 101\nType:Deluxe\n-----------------");
        Room r1=new Room();
        r1.roomno.setText(String.valueOf(rno));
        r1.roomType.setText("Deluxe");
        r1.b1.doClick();
        System.out.println(r1.message);
        //assertTrue(r1.room_no!=0);
        assertEquals(1,r1.flag);
        Thread.sleep(2000);
    }



}