package vtu30309.Spring_Employee_management;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(EmployeeConfig.class);

        EmployeeDAO dao = context.getBean(EmployeeDAO.class);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Insert");
            System.out.println("2. View All");
            System.out.println("3. Delete");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = Double.parseDouble(sc.nextLine());

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    dao.insertEmployee(new Employee(id, name, salary, dept));
                    System.out.println("Employee Added!");
                    break;

                case 2:
                    List<Employee> list = dao.getAllEmployees();
                    list.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    dao.deleteEmployee(deleteId);
                    System.out.println("Deleted Successfully!");
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}
