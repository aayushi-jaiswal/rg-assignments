import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

class EmployeeCRUD {
    private List<Employee> employees = new ArrayList<>();

    // Create
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Read
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // Update
    public boolean updateEmployee(int id, String name, String department) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setDepartment(department);
                return true;
            }
        }
        return false;
    }

    // Delete
    public boolean deleteEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeCRUD employeeCRUD = new EmployeeCRUD();

        // Create
        employeeCRUD.addEmployee(new Employee(1, "Aayushi", "Engineering"));
        employeeCRUD.addEmployee(new Employee(2, "Princy", "Marketing"));

        // Read
        System.out.println("All Employees:");
        for (Employee employee : employeeCRUD.getAllEmployees()) {
            System.out.println(employee);
        }

        System.out.println("Get Employee by ID 1:");
        System.out.println(employeeCRUD.getEmployeeById(1));

        // Update
        employeeCRUD.updateEmployee(1, "Prachi", "Product Development");
        System.out.println("Updated Employee with ID 1:");
        System.out.println(employeeCRUD.getEmployeeById(1));

        // Delete
        employeeCRUD.deleteEmployee(2);
        System.out.println("All Employees after deletion:");
        for (Employee employee : employeeCRUD.getAllEmployees()) {
            System.out.println(employee);
        }
    }
}
