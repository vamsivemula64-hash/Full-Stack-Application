package vtu30309.Spring_Employee_management;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO employee (emp_id, emp_name, salary, department) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                employee.getEmpId(),
                employee.getEmpName(),
                employee.getSalary(),
                employee.getDepartment());
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getDouble("salary"),
                        rs.getString("department")
                ));
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET emp_name=?, salary=?, department=? WHERE emp_id=?";
        jdbcTemplate.update(sql,
                employee.getEmpName(),
                employee.getSalary(),
                employee.getDepartment(),
                employee.getEmpId());
    }

    @Override
    public void deleteEmployee(int empId) {
        String sql = "DELETE FROM employee WHERE emp_id=?";
        jdbcTemplate.update(sql, empId);
    }
}
