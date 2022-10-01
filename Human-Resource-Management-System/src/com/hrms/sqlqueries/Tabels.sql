
create database hrms ;

create table department (
						deptId int primary key auto_increment ,
						deptName varchar(25) unique not null ,
						deptLoc varchar(25) not null
						) ;
						
						
						
create table employee(
						empId int PRIMARY KEY AUTO_INCREMENT,
						empName varchar(25) NOT NULL,
						empuser varchar(25) UNIQUE NOT NULL,
						emppass varchar(25) NOT NULL,
						empDepId int NOT NULL,
						empSal int NOT NULL,
						empJoin date NOT NULL,
						empLeave int NOT NULL,
						empMangId int NOT NULL,
						FOREIGN KEY (empDepId) references department(deptId) ; 
						);
						

create table Admin(
					    adminId int PRIMARY KEY AUTO_INCREMENT,
					    adminName varchar(25) NOT NULL,
					    adminuser varchar(25) UNIQUE NOT NULL,
					    adminpass varchar(25) NOT NULL,
					    
					    );
						
Create table Leaves(	
						empId int UNIQUE NOT NULL ,
						Leave_NO int PRIMARY KEY AUTO_INCREMENT,
						leaveday int NOT NULL,
						leaveres varchar(25) NOT NULL
						) ;
						

				
				
				
				
 insert into department(deptName,deptLoc) values('Frontend' , 'Amravati') ;
Query OK, 1 row affected (0.01 sec)
