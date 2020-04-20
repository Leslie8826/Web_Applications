-- Below are the SQL statements for the creation of the MySQL database as well as the single table of employees 
-- and the insertion of data in that table 

-- Creation of the database
create database test_for_select;

use test_for_select;

-- Creation of the single table of the database
create table Employees(
id int not null,
firstName varchar (255),
lastName varchar (255),
yearlySalary int not null
);

-- Test to see if table is created
select * from Employees;

-- Insertion of data in the database
insert into Employees values (1, 'Ella', 'Johns', 190000);
insert into Employees values (2, 'Paul', ' Goge', 140000);

insert into Employees values (3, 'Mary', 'Franck', 370000),
(4, 'James', 'Williams', 189000);


-- Test to check if data were inserted
select * from Employees;

SELECT id, firstName, lastName, yearlySalary FROM Employees;
