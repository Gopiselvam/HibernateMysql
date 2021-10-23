package com.employeeAccount;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class EmployeeAccountService {

    private EmpAccDao dao;
    Scanner sc = new Scanner(System.in);

    public EmployeeAccountService(){
        dao = new EmpAccDao();
    }

    /*
    deve.gowda.hd@gmail.com
Deve Gowda
HD
2
ACC_1996
ACC_1997
     */
    public void AddEmployee(){
        System.out.println("Enter Employee email id");
        String email = sc.nextLine();
        System.out.println("Enter first name");
        String firstName = sc.nextLine();
        System.out.println("Enter last name");
        String lastName = sc.nextLine();

        EmployeeAcc employeeAcc = new EmployeeAcc();
        employeeAcc.setEmail(email);
        employeeAcc.setFirstName(firstName);
        employeeAcc.setLastName(lastName);

        System.out.println("Enter the number of accounts needs to be created");
        int n = sc.nextInt(); sc.nextLine();


        Account account = null;
        Set<Account> accountSet = new LinkedHashSet<>();
        for(int i=1; i<=n; i++){
            System.out.println("Enter the Account:"+i+" details [account number]");
            account = new Account();
            String accNum = sc.nextLine();
            account.setAccountNumber(accNum);
            accountSet.add(account);
        }
        employeeAcc.setAccounts(accountSet);
        dao.addEmployee(employeeAcc);
        System.out.println("Employee added successfully");
    }

    public void getEmployee(){
        System.out.println("Enter the email");
        String email = sc.nextLine();
        EmployeeAcc employeeAcc = dao.getEmployeeAccByEmail(email);
        System.out.println("Employee etched successfully\ndetails below\n");
        System.out.println(employeeAcc);
    }
}
