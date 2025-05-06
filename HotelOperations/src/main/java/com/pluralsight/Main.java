package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        //testReservation1();
        testEmployee();
        testRoom();
    }


    public static void testEmployee(){

        Employee e1 = new Employee(1, "Matt", "Facilitators", 10);

        e1.punchIn(8);
        e1.punchOut(12);

        System.out.println(e1.getTotalPay());

        Employee e2 = new Employee(1, "Matt", "Facilitators", 10);
        e2.setHoursWorked(40);
        System.out.println(e2.getTotalPay());

        Employee e3 = new Employee(1, "Matt", "Facilitators", 10);
        e3.setHoursWorked(41);
        System.out.println(e3.getTotalPay());



    }

    public static void testRoom() {
        Room r1 = new Room(1, 150);
        System.out.println(r1.isAvailable());
        r1.checkIn();
        System.out.println(r1.isAvailable());
    }

}