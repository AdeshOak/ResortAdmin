package Ass4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CheckInTest {
    CheckIn c1=new CheckIn();


    @Test
    public void allCorrect() throws InterruptedException {
        String name="Gaurav Zanpure";
        String pno="9561211191";
        String aadhar="444433332221";
        c1.name.setText(name);
        c1.phone.setText(pno);
        c1.aadhar.setText(aadhar);
        c1.rtype.setSelectedItem("Deluxe");
        c1.assign_room.doClick();
        c1.deposit.setText("1000");
        c1.checkin.doClick();
        assertNotNull(name);
        assertTrue(pno.length() == 10 && aadhar.length()==12);
        Thread.sleep(2000);
    }

    @Test
    public void allinCorrect() throws InterruptedException {
        String name="Adesh Oak";
        String pno="95612111";
        String aadhar="4444333321";
        c1.name.setText(name);
        c1.phone.setText(pno);
        c1.aadhar.setText(aadhar);
        c1.rtype.setSelectedItem("Suite");
        c1.assign_room.doClick();
        c1.deposit.setText("1000");
        c1.checkin.doClick();
        assertNotNull(name);
        assertTrue(pno.length() == 10 && aadhar.length()==12);
        /*assertEquals(10,pno.length());
        assertEquals(12,aadhar.length());*/
        Thread.sleep(2000);
    }



}