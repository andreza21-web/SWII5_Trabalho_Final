CREATE DATABASE inventario;
USE inventario;

CREATE TABLE Salesman(
salesman_id int auto_increment PRIMARY KEY,
name varchar(30),
city varchar(15),
commission decimal(5,2)
);

CREATE TABLE Customer(
customer_id int auto_increment PRIMARY KEY,
cust_name varchar(30),
city varchar(15),
grade numeric(3),
salesman_id numeric(5)
);

CREATE TABLE Orders(
ord_no int auto_increment PRIMARY KEY,
purch_amt decimal(8,2),
ord_date date,
customer_id int,
salesman_id int,
FOREIGN KEY (customer_id) references Customer(customer_id),
FOREIGN KEY (salesman_id) references Salesman(salesman_id)
);

show tables;

