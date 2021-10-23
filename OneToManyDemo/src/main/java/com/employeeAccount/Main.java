package com.employeeAccount;

import java.util.Scanner;

public class Main {
    private static EmployeeAccountService service = new EmployeeAccountService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = 0;
        loop1:while(true){
            System.out.println("press\n1: add employee\n2: get employee");
            num = sc.nextInt(); sc.nextLine();
            switch (num){

                case 1 :
                    service.AddEmployee();
                    break;
                case 2 :
                    service.getEmployee();
                default:
                    System.out.println("Exiting");
                    break loop1;
            }
        }


    }
}
