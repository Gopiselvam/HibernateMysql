create table EMPLOYEEACC (ID int primary key AUTO_INCREMENT, EMAIL varchar(30), FIRSTNAME varchar(20), LASTNAME varchar(20));
create table ACCOUNT (ID int primary key AUTO_INCREMENT, ACCOUNTNUMBER varchar(30), EMPLOYEE_ID int);