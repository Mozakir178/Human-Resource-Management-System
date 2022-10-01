insert into department(deptName,deptLoc) values('Frontend' , 'Amravati') ;
Query OK, 1 row affected (0.01 sec)


 select * from department ;
+--------+----------------+-----------+
| deptId | deptName       | deptLoc   |
+--------+----------------+-----------+
|     14 | Human Resource | Amravati  |
|     15 | Marketing      | Pune      |
|     16 | Sales          | Mumbai    |
|     17 | Design         | Bangalore |
|     20 | Backend        | Amravati  |
|     21 | Frontend       | Amravati  |
+--------+----------------+-----------+
6 rows in set (0.00 sec)


select * from employee ;
+-------+----------------+---------+----------+----------+--------+------------+----------+-----------+
| empId | empName        | empuser | emppass  | empDepId | empSal | empJoin    | empLeave | empMangId |
+-------+----------------+---------+----------+----------+--------+------------+----------+-----------+
|    10 | Mohammad Zakir | zakir   | zakir123 |       17 |  50000 | 2022-10-01 |       24 |         1 |
|    11 | Manoohar Kumar | manohar | 1234     |       15 |  40000 | 2022-10-01 |       24 |         2 |
|    12 | Suresh Prabhu  | suresh  | 1234     |       15 |  30000 | 2022-10-01 |       24 |         3 |
|    18 | Kartik Sharma  | kartik  | 1234     |       17 |  30000 | 2022-10-01 |       24 |         1 |
+-------+----------------+---------+----------+----------+--------+------------+----------+-----------+
4 rows in set (0.00 sec)


select * from employee where empDepId = 15 ;
+-------+----------------+---------+---------+----------+--------+------------+----------+-----------+
| empId | empName        | empuser | emppass | empDepId | empSal | empJoin    | empLeave | empMangId |
+-------+----------------+---------+---------+----------+--------+------------+----------+-----------+
|    11 | Manoohar Kumar | manohar | 1234    |       15 |  40000 | 2022-10-01 |       24 |         2 |
|    12 | Suresh Prabhu  | suresh  | 1234    |       15 |  30000 | 2022-10-01 |       24 |         3 |
+-------+----------------+---------+---------+----------+--------+------------+----------+-----------+
2 rows in set (0.00 sec)


 insert into employee values(19 , 'Khizar Ahmad' , 'khizar' , 'khizar12' , 14 , 40000 , '2022-10-02',24 , 2) ;
Query OK, 1 row affected (0.01 sec)



update employee set empDepId = 15 where empId = 18 ;
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0



 select * from leaves ;
+-------+---------+----------+----------+
| empId | leaveNo | leaveday | leaveres |
+-------+---------+----------+----------+
|    10 |      12 |        5 | Health   |
+-------+---------+----------+----------+
1 row in set (0.00 sec)


 select * from employee inner join department where empId =  10 group by empId;
+-------+----------------+---------+----------+----------+--------+------------+----------+-----------+--------+----------------+----------+
| empId | empName        | empuser | emppass  | empDepId | empSal | empJoin    | empLeave | empMangId | deptId | deptName       | deptLoc  |
+-------+----------------+---------+----------+----------+--------+------------+----------+-----------+--------+----------------+----------+
|    10 | Mohammad Zakir | zakir   | zakir123 |       17 |  50000 | 2022-10-01 |       24 |         1 |     14 | Human Resource | Amravati |
+-------+----------------+---------+----------+----------+--------+------------+----------+-----------+--------+----------------+----------+
1 row in set (0.00 sec)







 update employee set emppass = 'zakir@123' where empId = 10 ;
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0


 insert into leaves values(11 , 13 , 7 , 'Wedding') ;
Query OK, 1 row affected (0.02 sec)