package vtu30309.Spring_Employee_management;

public class Employee {

    private int empId;
    private String empName;
    private double salary;
    private String department;

    public Employee() {}

    public Employee(int empId, String empName, double salary, String department) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.department = department;
    }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return empId + " | " + empName + " | " + salary + " | " + department;
    }
}
