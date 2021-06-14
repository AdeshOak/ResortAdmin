package Ass4;

public class Customer {                         //Customer class to store customer information
    String name,aadhar,phno,booked_room,payment_status;
    int room_no;

    int depo,mtobepaid;

    Customer(){
    }
    Customer(String cname,String caadhar,String cphone,String room_type,int rno,int dep,int remamt,String pstatus){//Parametrized constructor
        name=cname;
        aadhar=caadhar;
        phno=cphone;
        booked_room=room_type;
        room_no=rno;
        depo=dep;
        mtobepaid=remamt;
        payment_status=pstatus;
    }
}