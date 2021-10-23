package com.employeeAccount;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String accountNumber;

    @ManyToOne
    private EmployeeAcc employeeAcc;

    public Account() {
    }

    public Account(int id, String accountNumber, EmployeeAcc employeeAcc) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.employeeAcc = employeeAcc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public EmployeeAcc getEmployeeAcc() {
        return employeeAcc;
    }

    public void setEmployeeAcc(EmployeeAcc employeeAcc) {
        this.employeeAcc = employeeAcc;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", employeeAcc=" + employeeAcc +
                '}';
    }
}
