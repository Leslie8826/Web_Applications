-- Below are the SQL statements for the creation of the MySQL database as well as the single table of employees 
-- and the insertion of data in that table create database test_for_select;

use test_for_select;

create table Employees(
id int not null,
firstName varchar (255),
lastName varchar (255),
yearlySalary int not null
);

select * from Employees;

insert into Employees values (1, 'Ella', 'Johns', 190000);
insert into Employees values (2, 'Paul', ' Goge', 140000);

insert into Employees values (3, 'Mary', 'Franck', 370000),
(4, 'James', 'Williams', 189000);

select * from Employees;


SELECT id, firstName, lastName, yearlySalary FROM Employees;
