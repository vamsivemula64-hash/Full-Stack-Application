 package vtu30309.Spring_Employee_management;
 
 import java.util.List;

 public interface EmployeeDAO {

     void insertEmployee(Employee employee);

     List<Employee> getAllEmployees();

     void updateEmployee(Employee employee);

     void deleteEmployee(int empId);
 }
