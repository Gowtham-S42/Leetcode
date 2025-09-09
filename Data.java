package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
//import Employee.employee;

public class Data {
	Connection getconnection() throws SQLException, ClassNotFoundException {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		return con;
	}
       int  Insert(Employee e) throws ClassNotFoundException, SQLException {
		Connection c  = getconnection();
		PreparedStatement pst=c.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		pst.setInt(1,e.getId());
		pst.setString(2,e.getName());
		pst.setInt(3,e.getAge());
		pst.setString(4,e.getDesignation());
		pst.setString(5,e.getDepartment());
		pst.setString(6, e.getManager());
		int a=pst.executeUpdate();
		c.close();
		return a;
	}
   public List<Employee> getallemployees()throws ClassNotFoundException, SQLException {
		 List<Employee> employees = new ArrayList<>();
	        Connection c = getconnection(); 
	             PreparedStatement pst = c.prepareStatement("SELECT * FROM employee") ;	             
	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                Employee employee = new Employee(
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getInt("age"),
	                    rs.getString("designation"),
	                    rs.getString("department"),
	                    rs.getString("manager")
	                );
	                employees.add(employee);
	            }    
	        return employees;
	            }
   
   public Employee findemployee(String name)throws ClassNotFoundException, SQLException {
		Connection c=getconnection();
		 PreparedStatement pst = c.prepareStatement("SELECT * FROM employee WHERE name = ?");
		 
	           pst.setString(1, name);
	            ResultSet rs = pst.executeQuery();
	            if (rs.next()) {
	                // Assuming the columns are in the same order as the Employee constructor
	                return new Employee(
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getInt("age"),
	                    rs.getString("job"),
	                    rs.getString("department"),
	                    rs.getString("manager")
	                );
	            } else {
	                return null;
	            }
	        }   
   
   public Employee findemployeenamebaseduponmanager(String manager)throws ClassNotFoundException, SQLException {
		Connection c=getconnection();
		 PreparedStatement pst = c.prepareStatement("SELECT * FROM employee WHERE manager = ?");
		 
	           pst.setString(1, manager);
	            ResultSet rs = pst.executeQuery();
	            if (rs.next()) {
	                // Assuming the columns are in the same order as the Employee constructor
	                return new Employee(
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getInt("age"),
	                    rs.getString("job"),
	                    rs.getString("department"),
	                    rs.getString("manager")
	                );
	            } else {
	                return null;
	            }
	        } 
   
   public Employee getreportingtreeofemployee(String manager)throws ClassNotFoundException, SQLException {
		Connection c=getconnection();
		 PreparedStatement pst = c.prepareStatement("SELECT name FROM employee WHERE manager = ?");
		 
	           pst.setString(1,manager);
	            ResultSet rs = pst.executeQuery();
	            if (rs.next()) {
	                // Assuming the columns are in the same order as the Employee constructor
	                return new Employee(
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getInt("age"),
	                    rs.getString("job"),
	                    rs.getString("department"),
	                    rs.getString("manager")
	                );
	            } else {
	                return null;
	            }
	        } 
}
