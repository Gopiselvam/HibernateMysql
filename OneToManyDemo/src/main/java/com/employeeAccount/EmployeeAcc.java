package com.employeeAccount;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EmployeeAcc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    private String firstName;

    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Set<Account> accounts;

    public EmployeeAcc() {
    }

    public EmployeeAcc(int id, String email, String firstName, String lastName, Set<Account> accounts) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "EmployeeAcc{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
