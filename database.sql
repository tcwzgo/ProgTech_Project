create database Maintance;

create table employees (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(40) not null,
	email VARCHAR(40) not null,
	post VARCHAR(40) not null,
	salary BIGINT not null	
);

create table factories (
	id INT PRIMARY KEY AUTO_INCREMENT,
	company_name VARCHAR(40),
	institution VARCHAR(40),
	address VARCHAR(40)
);

create table employee_workplace (
	id INT PRIMARY KEY AUTO_INCREMENT,
	employee_id INT,
	factory_id INT,

	FOREIGN KEY (employee_id) REFERENCES employees(id),
	FOREIGN KEY (factory_id) REFERENCES factories(id)
);

insert into employees (name, email, post, salary) values ("Teszt Elek", "tesztelek@gmail.com", "secretary", 250000)