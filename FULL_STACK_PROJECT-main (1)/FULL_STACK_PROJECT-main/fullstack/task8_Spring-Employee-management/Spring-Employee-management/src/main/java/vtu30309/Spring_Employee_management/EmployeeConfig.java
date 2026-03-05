package vtu30309.Spring_Employee_management;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class EmployeeConfig {

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/employee_db");
        ds.setUsername("root");
        ds.setPassword("YOUR_PASSWORD");   // 🔥 change this

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public EmployeeDAO employeeDAO() {
        EmployeeDAOImpl dao = new EmployeeDAOImpl();
        dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }
}
