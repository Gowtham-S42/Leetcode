package employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Employeemain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		Data d=new Data();
		while(true) {
			System.out.println("1.insert the employee details");
			System.out.println("2.printall employee details");
			System.out.println("3.Searching employee details ");
			System.out.println("4.Employee under the given manager name of the department");
			System.out.println("5.reporting to tree of the given employee name ");
			System.out.println("6.Exit the program ");
			 System.out.println("enter your option");
			 int option =s.nextInt();
			 switch(option) {
				case 1:
					System.out.println("enter the id");
					int id =s.nextInt();
					System.out.println("enter the name");
					String name=s.next();
					System.out.println("enter the age");
					int age=s.nextInt();
					System.out.println("enter the designation");
					String designation =s.next();
					System.out.println("enter the department ");
					String department =s.next();
					System.out.println("enter the manager");
					String manager =s.next();
				Employee e = new Employee(id, name, age, designation, department,manager);
				int a =d.Insert(e);
				System.out.println("data entered if you have a doubt click 4 ");
				break;
				case 2:
					 List<Employee> employees = d.getallemployees();
	                 if (!employees.isEmpty()) {
	                	 System.out.println("Employee Details:");
	       	          
	                     System.out.printf("%-10s %-20s %-30d %-15s %-20s %-20s %n", "ID", "Name","Age","designation", "Department","manager");
	                     for (Employee emp : employees) {
	                         System.out.println(emp);
	                     }
	                     
	                 } else {
	                	 System.out.println("No employees found.");
	                 }
	                 break;
				case 3:
					 System.out.print("Enter name of employee to find: ");
	                 String name1 = s.next();
	                 Employee fetchedEmployee = d.findemployee(name1);
	                 if (fetchedEmployee != null) {
	                     System.out.println("Employee Details: " + fetchedEmployee);
	                 } else {
	                     System.out.println("Employee not found.");
	                 }
	                 break;
				case 4:
					System.out.println("Enter name of manager under on department");
					String manager1 = s.next();
	                 Employee fetchedmanager = d.findemployeenamebaseduponmanager(manager1);
	                 if (fetchedmanager != null) {
	                     System.out.println("Employee Details: " + fetchedmanager);
	                 } else {
	                     System.out.println("Employee not found.");
	                 }
	                 break;
				case 5:
					System.out.println("enter the name of reporting tree relation");
					String manager2 = s.next();
	                 Employee fetchedmanager1 = d.getreportingtreeofemployee(manager2);
	                 if (fetchedmanager1 != null) {
	                     System.out.println("Employee Details: " + fetchedmanager1);
	                 } else {
	                     System.out.println("Employee not found.");
	                 }
	                 break;
				case 6:
					System.exit(0);
					break;
					default:
						System.out.println("option is inavalid ");
			 }	 
		}
	}
}
