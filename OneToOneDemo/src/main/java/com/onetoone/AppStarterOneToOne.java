package com.onetoone;

import java.sql.Date;

public class AppStarterOneToOne {

    public static void main(String[] args) {

        LockerService lockerService = new LockerService();

        Locker locker = new Locker("L101", "small", 500);
        Customer customer = new Customer(101, "Howard wolowitz",
                Date.valueOf("1994-05-01"), "layout-01", "7894561235", locker);

        lockerService.addCustomerWithLocker(customer);
        System.out.println("Done");
    }


}
