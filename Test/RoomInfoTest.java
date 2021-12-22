package Ass4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomInfoTest {

    @Test
    public void testViewRooms() throws InterruptedException {
        RoomInfo r1 = new RoomInfo();
        r1.setVisible(true);
        Thread.sleep(2000);
        r1.b1.doClick();
        Thread.sleep(6000);
        assertEquals(1,r1.flag,"PASS!");
    }

}