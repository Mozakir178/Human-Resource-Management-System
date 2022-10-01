import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

import com.hrms.Exceptions.DepartmentException;
import com.hrms.Util.DBConnection;
import com.hrms.bean.Department;
import com.hrms.bean.Employee;
import com.hrms.bean.EmployeeDto;
import com.hrms.bean.Leaves;
import com.hrms.dao.DepartmentDao;
import com.hrms.dao.DepartmentDaoImp;
import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImp;
import com.hrms.dao.EmployeeLeveImp;
import com.hrms.dao.EmployeeLevel;

public class HRMS_APP {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		System.out.println("Welcone to Human Resource Management System HomePage \n===========================================================");
		boolean run = true ;
		while(run) {
			
			
			try {
			System.out.println("Please Select correct option");
				System.out.println("1. Press 1 for login as Admin");
				System.out.println("2. Press 2 for login as Employee");
				System.out.println("3. Press 3 for exit");
				System.out.println("===========================================================");
				int x = Integer.parseInt(sc.nextLine()) ;
				
				
				if(x== 3) {
					run = false ;
					break ;
				}
				if(x==1) {
				try {
					System.out.println("Enter Your admin username");
					String username = sc.nextLine() ;
					System.out.println("Enter Your admin password");
					String password = sc.nextLine() ;
					EmployeeDao employeeDao = new EmployeeDaoImp() ;
					DepartmentDao departmentDao = new DepartmentDaoImp() ;
					boolean result = employeeDao.adminLogin(username, password) ;
					if(result ) {						
						try {
							boolean adminOperation = true ;
							while(adminOperation) {
								System.out.println("\nSelect operation you want to perform \n===========================================================");
								System.out.println("1. Add Department");
								System.out.println("2. View Department");
								System.out.println("3. View Employee List");
								System.out.println("4. View Employee List By Department Id");
								System.out.println("5. Add New Employee");
								System.out.println("6. Transfer Employee to other department");
								System.out.println("7. View Leaves request");
								System.out.println("8. Logout");
								System.out.println("9. Exit");
								System.out.println("===========================================================\n");
								
								try {
									int adminFirstChoice = Integer.parseInt(sc.nextLine()) ;
								
								
								if(adminFirstChoice == 1) {
									try {
										System.out.println("Enter Department name");
										String dname = sc.nextLine() ;
										System.out.println("Enter Location of the Department");
										String dloc = sc.nextLine() ;
										System.out.println("===========================================================\n");
										int id = 0 ;
										String departmentAdd = departmentDao.addDepartment( new Department(id, dname, dloc) ) ;
										System.out.println(departmentAdd);
										System.out.println("===========================================================\n");
									} catch (Exception e) {
										System.out.println(e.getMessage());
									}
								}
								else if(adminFirstChoice == 2) {
									List<Department> allDepartmentList  = null ;
									try {
										System.out.println("===========================================================\n");
										allDepartmentList = departmentDao.viewDepartment() ;
										allDepartmentList.forEach(s-> {
											System.out.println("Department Id : " + s.getDeptId()) ;
											System.out.println("Department Name : " + s.getDeptName()) ;
											System.out.println("Department Location : " + s.getDeptLoc()) ;
											System.out.println("===========================================================\n") ;
										});
									} catch (DepartmentException e) {
										System.out.println(e.getMessage());
										System.out.println("===========================================================\n");
									} catch (Exception e) {
										System.out.println(e.getMessage());
										System.out.println("===========================================================\n");
									}
									
								}
								
								else if(adminFirstChoice == 5) {
									try {
										System.out.println("Enter Employee Details\n===========================================================");
										int employeeId = 0 ;
										System.out.println("Enter Employee Name: ");
										String employeeName = sc.nextLine() ;
										System.out.println("Enter Employee Username");
										String employeeUsername = sc.nextLine() ;
										System.out.println("Generate Employee Password");
										String employeePassword = sc.nextLine() ;
										System.out.println("Enter department number you want to assign to this employee");
										int employeeDeptNo = Integer.parseInt(sc.nextLine()) ;
										System.out.println("Enter Manager Id of Department");
										int employeeMangId = Integer.parseInt(sc.nextLine()) ;
										System.out.println("Enter Salary of Employee");
										int employeeSal = Integer.parseInt(sc.nextLine()) ;
										DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd") ;
										LocalDateTime now = LocalDateTime.now() ;
										String employeeDate = dtf.format(now) ;
										int employeeLeave = 24 ;
										
										String addEmployee = employeeDao.ragisterEmployee(new Employee(employeeId, employeeUsername, employeePassword, employeeName, employeeDeptNo, employeeMangId, employeeSal, employeeDate, employeeLeave) ) ;
										System.out.println(addEmployee);
										System.out.println("===========================================================\n");
									} catch (Exception e) {
										System.out.println(e.getMessage());
									}
								}
								else if(adminFirstChoice == 3) {
									try {
										List<Employee> employeeList = employeeDao.viewEmployee() ;
										employeeList.forEach(s ->{
											System.out.println(s) ;
											System.out.println() ;
											}) ;
										System.out.println("===========================================================\n");
									} catch (Exception e) {
										System.out.println(e.getMessage());
									}
									
								}
								else if(adminFirstChoice == 4) {
									try {
										System.out.println("Enter department id");
										int id = Integer.parseInt(sc.nextLine()) ;
										List<Employee> employeeList = employeeDao.viewEmployeeByDepartment(id) ;
										employeeList.forEach(s ->{
											System.out.println(s) ;
											System.out.println() ;
											}) ;
										System.out.println("===========================================================\n");
									} catch (Exception e) {
										System.out.println(e.getMessage());
									}
								}
								else if(adminFirstChoice == 6) {
									try {
										System.out.println("Enter Employee Id you want to transfer");
										int transferEmployeeId = Integer.parseInt(sc.nextLine()) ;
										System.out.println("Enter Department Id where you want to transfer");
										int transferDepartmentId = Integer.parseInt(sc.nextLine()) ;
										
										String transferEmployee = employeeDao.transferEmployee(transferEmployeeId, transferDepartmentId) ;
										System.out.println(transferEmployee);
										System.out.println("===========================================================\n");
									} catch (Exception e) {
										System.out.println(e.getMessage());
									}
								}
								else if(adminFirstChoice == 7) {
									try {
										List<Leaves> allPendingLeaves = employeeDao.getLeavesList() ;
										allPendingLeaves.forEach(s -> System.out.println(s)) ;
										
										boolean leaveRequestOption = true ;
										while(leaveRequestOption) {
											System.out.println("If you want to accept or reject a request select option below");
											System.out.println("1. Enter 1 to accept a leave request");
											System.out.println("2. Enter 2 to reject a leave request");
											System.out.println("3. Enter 3 to go Back");
											System.out.println("4. Enter 4 to Logout");
											System.out.println("5. Enter 5 to Exit");
											System.out.println("===========================================================\n");
											int leaveRequestChoice = 6 ;
											try {
												leaveRequestChoice = Integer.parseInt(sc.nextLine()) ;
											} catch (Exception e) {
												
											}
											if(leaveRequestChoice == 1) {
												System.out.println("Enter The Employee Id you want to accept the Leave request");
												int employeeIdForLeave = Integer.parseInt(sc.nextLine() ) ;
												String acceptLeave = employeeDao.acceptLeave(employeeIdForLeave) ;
												System.out.println(acceptLeave);
												System.out.println("===========================================================\n");
											}
											else if( leaveRequestChoice == 2) {
												System.out.println("Enter The Employee Id you want to reject the Leave request");
												int employeeIdForLeave = Integer.parseInt(sc.nextLine() ) ;
												String rejectLeave = employeeDao.acceptLeave(employeeIdForLeave) ;
												System.out.println(rejectLeave);
												System.out.println("===========================================================\n");
											}
											else if(leaveRequestChoice == 3) {
												leaveRequestOption = false ;
											}
											else if(leaveRequestChoice == 4) {
												leaveRequestOption = false ;
												adminOperation = false ;
											}
											else if(leaveRequestChoice == 5 ) {
												leaveRequestOption = false ;
												adminOperation = false ;
												run = false ;
											}
											else {
												System.out.println("Enter right input");
											}
										}
										
									} catch (Exception e) {
										System.out.println(e.getMessage());
										System.out.println("===========================================================\n");
									}
								}
								
								else if(adminFirstChoice == 8) {
									adminOperation = false ;
								}
								else if(adminFirstChoice == 9) {
									adminOperation = false ;
									run = false ;
								}
								else {
									System.out.println("Enter Right input");
									System.out.println("===========================================================\n");
								}
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}	
							}
								
							
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
					else {
						System.out.println("Wrong username or Password");
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				}
				else if ( x == 2) {
					try {
						System.out.println("Please Login fisrt");                  
						System.out.println("Enter Your Username");
						String employeeUsername = sc.nextLine() ;
						System.out.println("Enter Your Password");
						String employeePassword = sc.nextLine() ;
						EmployeeLevel employeeLevelAccess = new EmployeeLeveImp() ;
						boolean result = employeeLevelAccess.employeeLogin(employeeUsername, employeePassword) ;
						if(result) {
							
							System.out.println("Login Successfull \n===========================================================" );
							boolean employeeOperation = true ;
							while(employeeOperation) {
								System.out.println("Select Operatiion you want to perform");
								System.out.println("1. Press 1 to view details");
								System.out.println("2. Press 2 to change password");
								System.out.println("3. Press 3 to apply for Leave");
								System.out.println("4. Press 4 to Logout");
								System.out.println("5. Press 5 to Exit");
								System.out.println("===========================================================\n");
								int employeeChoice = 6 ;
								try {
									employeeChoice = Integer.parseInt(sc.nextLine()) ;
								} catch (Exception e) {
								}
								int employeeId = employeeLevelAccess.empId(employeeUsername);
								if(employeeChoice == 1) {
									try {
//										System.out.println("Please Enter your Employee Id");
										
										EmployeeDto employee = employeeLevelAccess.viewDetails(employeeId) ;
										System.out.println("Your Employee Id:           "+employee.getEmpId());
										System.out.println("Your Employee Name:         "+employee.getName());
										System.out.println("Your Employee Username:     "+employee.getUsername());
										System.out.println("Your Salary:                "+employee.getSalary());
										System.out.println("Your Joining Date:          "+employee.getJoinDate());
										System.out.println("Your Remaining Leaves:      "+employee.getLeaveAvi());
										System.out.println("Your Department Id:         "+employee.getDeptId());
										System.out.println("Your Manager Id:            "+employee.getMangId());
										System.out.println("Your Department Location:   "+employee.getDeptLoc());
										System.out.println("===========================================================\n");
									} catch (Exception e) {
										System.out.println(e.getMessage());
										System.out.println("===========================================================\n");
									}
									
								}
								else if(employeeChoice == 2) {
//									System.out.println("Enter your Employee Id ");
//									int employeeId = Integer.parseInt(sc.nextLine()) ;
									try {
										System.out.println("Enter new password");
										String empPassword = sc.nextLine() ;
										String changePassword = employeeLevelAccess.updatePassword(employeeId, empPassword) ;
										System.out.println(changePassword);
										System.out.println("===========================================================\n");
									} catch (Exception e) {
										System.out.println(e.getMessage());
									}
									
								}
								else if(employeeChoice == 3) {
//									System.out.println("Enter your Employee Id");
//									int employeeId = Integer.parseInt(sc.nextLine()) ;
									try {
										System.out.println("Enter How many days off you want");
										int daysOff = Integer.parseInt(sc.nextLine()) ;
										System.out.println("Enter reason for leave");
										String reason = sc.nextLine() ;
										String applyForLeave = employeeLevelAccess.applyForLeave(employeeId, daysOff, reason);
										System.out.println(applyForLeave);
										System.out.println("===========================================================\n");
									} catch (Exception e) {
										System.out.println(e.getMessage());
									}
								}
								else if(employeeChoice == 4) {
									employeeOperation = false ;
								}
								else if(employeeChoice == 5) {
									employeeOperation = false ;
									run = false ;
								}
								else {
									System.out.println("Please enter correct details");
									System.out.println("===========================================================\n");
								}
							}
							
						}
						else {
							System.out.println("Wrong username or password");
						}
						
					
					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("===========================================================\n");
					}
				
				}
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("===========================================================\n");
			}
			
			
			
			
			
			
		}
		System.out.println("Thank you for using our Human Resource Management System");
		
	}

}
