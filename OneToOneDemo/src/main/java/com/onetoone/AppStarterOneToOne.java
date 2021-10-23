package com.onetoone;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppStarterOneToOne {

    private static LockerDao lockerDao = new LockerDao();

    public static void main(String[] args) {

//        addCustomerAndLocker();
//        addLockerToExistingCustomer();
        getCustomer();
//        deleteLocker();
//        getLockers();
//        assignExistingLockerToCustomer();
        System.out.println("Done");
    }

    private static void assignExistingLockerToCustomer() {
        System.out.println("Enter the customer id");
        Scanner sc = new Scanner(System.in);
        int custId = sc.nextInt();
        sc.nextLine();
        System.out.println("Select one of the following empty lockers");
        getLockers();
        String lockerId = sc.nextLine();
        lockerDao.addExistingLockerToCustomer(custId, lockerId);
        System.out.println("locker "+lockerId+" added to "+custId+" successfully");
    }

    private static void getLockers() {
        List<String> list = lockerDao.getAvailableLockers();
        String res = String.join(",", list);
        System.out.println(res);
    }

    /*
    L105
     */
    private static void deleteLocker() {
        System.out.println("Enter your customer id");
        lockerDao.deleteLocker(new Scanner(System.in).nextInt());
        System.out.println("locker deleted successfully");
    }

    /*
    101
     */
    private static void getCustomer() {
        System.out.println("Enter customer id");
        int custId = new Scanner(System.in).nextInt();
        Customer customer = lockerDao.getCustomer(custId);
        System.out.println(customer);
    }

    /*

    103
    L103
    small
    1500
     */
    private static void addLockerToExistingCustomer() {
        System.out.println("Enter the customer id");
        Scanner sc = new Scanner(System.in);
        int custId  = sc.nextInt();
        sc.nextLine();
        Locker locker = new Locker();
        System.out.println("Enter the locker number");
        locker.setLockerId(sc.nextLine());
        System.out.println("Enter the locker type");
        locker.setLockerType(sc.nextLine());
        System.out.println("Enter the locker Rent");
        locker.setRent(sc.nextInt());
        LockerDao lockerDao = new LockerDao();
        lockerDao.addLockerToCustomer(custId, locker);
        System.out.println("Locker added to customer id = "+custId);
    }

    /*
    101
    Bernadette wolowitz
    06/01/1995
    layout-101
    9638527417

    L101
    small
    500

     */
    private static void addCustomerAndLocker() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the username");
        String customerName = sc.nextLine();

        System.out.println("Enter DOB in MM/dd/yyyy");
        String datestr = sc.nextLine();
//        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        DateTimeFormatter frmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Date dob = java.sql.Date.valueOf(LocalDate.parse(datestr, frmt));

//        Date dob = (Date) formatter.parse(datestr);

        System.out.println("Enter the address");
        String addr = sc.nextLine();

        System.out.println("Enter phone number");
        String phone = sc.nextLine();
        Locker locker = null;
        System.out.println("Do you want to provide locker for this customer? y/n");
        if("y".equalsIgnoreCase(sc.nextLine())){
            System.out.println("Enter the locker number");
            String lockernumber = sc.nextLine();


            System.out.println("Enter the locker type");
            String loctype = sc.nextLine();

            System.out.println("Enter the rent paid");
            int rent = sc.nextInt();
            sc.nextLine();


            locker = new Locker();
            locker.setLockerId(lockernumber);
            locker.setLockerType(loctype);
            locker.setRent(rent);
        }

        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setDateOfBirth(dob);
        customer.setAddress(addr);
        customer.setPhoneNumber(phone);
        customer.setLocker(locker);

        LockerDao lockerService = new LockerDao();
        lockerService.addCustomerWithLocker(customer);
    }


}
