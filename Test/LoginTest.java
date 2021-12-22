package Ass4;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    Login l1=new Login();


    @Test
    public void testLoginPwdIncorrect() throws InterruptedException{
        System.out.println("Checking for 4 Test cases");
        System.out.println("\n---TEST CASE 1---\n Username = CORRECT \n Password = INCORRECT \n-----------------");
        l1.uname.setText("admin");
        l1.pwd.setText("root");
        l1.b1.doClick();
        System.out.println(l1.err);
        Thread.sleep(1000);
    }

    @Test
    public void testLoginBothIncorrect() throws InterruptedException{
        System.out.println("\n---TEST CASE 2---\n Username = INCORRECT \n Password = INCORRECT \n-----------------");
        l1.uname.setText("root");
        l1.pwd.setText("root");
        l1.b1.doClick();
        System.out.println(l1.err);
        Thread.sleep(1000);
    }

    @Test
    public void testLoginCorrect() throws InterruptedException {


        System.out.println("\n---TEST CASE 3---\n Username = CORRECT \n Password = CORRECT \n-----------------");
        l1.uname.setText("admin");
        l1.pwd.setText("admin");
        l1.b1.doClick();
        System.out.println(l1.err+"\n----------------------");
        Thread.sleep(1000);
    }

    @Test
    public void testLoginUnameIncorrect() throws InterruptedException{
        System.out.println("\n---TEST CASE 4---\n Username = INCORRECT \n Password = CORRECT \n-----------------");
        l1.uname.setText("root");
        l1.pwd.setText("admin");
        l1.b1.doClick();
        System.out.println(l1.err);
        Thread.sleep(1000);
    }




}