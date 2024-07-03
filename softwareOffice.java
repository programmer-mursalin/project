package software_office_management;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

class Software_office_management {
    private int Emp_id;
    private String name;
    private int salary;
    private String address;
    private String role;
    private String Dept_name;
    private int Dept_id;
    private int payment_amount;
    private String payment_type;
    private String date;
    private String month;
    private int year;
    private String soft_name;
    private String status;
    private String sell_institute;
    private int price;
    private String sell_time;
    private int proj_id;
    private String proj_name;
    private int leader_id;
    private int review;

    public Software_office_management() {
        this.Emp_id = 0;
        this.name = "";
        this.salary = 0;
        this.address = "";
        this.role = "";
        this.Dept_id = 0;
        this.Dept_name = "";
        this.payment_amount = 0;
        this.payment_type = "";
        this.date = "";
        this.leader_id = 0;
        this.month = "";
        this.price = 0;
        this.proj_id = 0;
        this.proj_name = "";
        this.review = 0;
        this.sell_institute = "";
        this.sell_time = "";
        this.soft_name = "";
        this.status = "";
        this.year = 0;
    }

    public int getEmp_id() {
        return Emp_id;
    }

    public void setEmp_id(int Emp_id) {
        this.Emp_id = Emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = (int) salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDept_id() {
        return Dept_id;
    }

    public void setDept_id(int Dept_id) {
        this.Dept_id = Dept_id;
    }

    public String getDept_name() {
        return Dept_name;
    }

    public void setDept_name(String Dept_name) {
        this.Dept_name = Dept_name;
    }

    public double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(double payment_amount) {
        this.payment_amount = (int) payment_amount;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(int leader_id) {
        this.leader_id = leader_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = (int) price;
    }

    public int getProj_id() {
        return proj_id;
    }

    public void setProj_id(int proj_id) {
        this.proj_id = proj_id;
    }

    public String getProj_name() {
        return proj_name;
    }

    public void setProj_name(String proj_name) {
        this.proj_name = proj_name;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public String getSell_institute() {
        return sell_institute;
    }

    public void setSell_institute(String sell_institute) {
        this.sell_institute = sell_institute;
    }

    public String getSell_time() {
        return sell_time;
    }

    public void setSell_time(String sell_time) {
        this.sell_time = sell_time;
    }

    public String getSoft_name() {
        return soft_name;
    }

    public void setSoft_name(String soft_name) {
        this.soft_name = soft_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}

public class Softwareofficemanagementsystem {
    private static final String HOST = "localhost";
    private static final String USER = "root";
    private static final String PW = "";
    private static final String DB = "software_office_management_system";
    private static Connection conn = null;

    public static void main(String[] args) throws IOException, SQLException {
        Software_office_management emp = new Software_office_management();

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/software office management system?zeroDateTimeBehavior=CONVERT_TO_NULL",
                    USER, PW);
            System.out.println("Database connected!");

            boolean exit = false;
            while (!exit) {
                clearScreen();
                System.out.println("Welcome to Shu IT Limited");
                System.out.println("***************************************");
                System.out.println("1. Specific month and year all salary");
                System.out.println("2. Department all employees");
                System.out.println("3. Department manager information");
                System.out.println("4. Which department employees made specific software");
                System.out.println("5. Complete software list");
                System.out.println("6. Incomplete software list");
                System.out.println("7. Highest employee salary");
                System.out.println("8. Total employees in each department");
                System.out.println("9. Last month salary");
                System.out.println("10. Highest selling software total amount");
                System.out.println("11. Total software sold each month");
                System.out.println("12. Employees not in any project");
                System.out.println("13. Employees in projects");
                System.out.println("14. Project leader information");
                System.out.println("15. Update employee review");
                System.out.println("16. Specific role all employees");
                System.out.println("17. Which seller bought highest software");
                System.out.println("18. Specific project employees");
                System.out.println("19. Show specific month salary");
                System.out.println("20. Exit");

                int val = getUserInput();

                switch (val) {
                    case 1:
                        thisMonthPaidSalary();
                        break;
                    case 2:
                        departmentAllEmployees();
                        break;
                    case 3:
                        deptManager();
                        break;
                    case 4:
                        deptEmpSoftware();
                        break;
                    case 5:
                        completeSoftwareList();
                        break;
                    case 6:
                        incompleteSoftwareList();
                        break;
                    case 7:
                        highestEmployeeSalary();
                        break;
                    case 8:
                        totalEmployeesEachDepartment();
                        break;
                    case 9:
                        lastMonthSalary();
                        break;
                    case 10:
                        highestSellingSoftwareTotalAmount();
                        break;
                    case 11:
                        totalSoftwareSoldEachMonth();
                        break;
                    case 12:
                        employeesNotInProjects();
                        break;
                    case 13:
                        employeesInProjects();
                        break;
                    case 14:
                        projectLeaderInformation();
                        break;
                    case 15:
                        updateEmployeeReview();
                        break;
                    case 16:
                        specificRoleAllEmployees();
                        break;
                    case 17:
                        whichSellerBoughtHighestSoftware();
                        break;
                    case 18:
                        specificProjectEmployees();
                        break;
                    case 19:
                        showSpecificMonthSalary();
                        break;
                    case 20:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Database not connected!");
        } finally {
            if (conn != null) {
                conn.close();
            }
            System.out.println("Database disconnected.");
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String getUserInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static float getUserInputFloat() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextFloat();
    }

    private static void waitForAction() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }

    private static void thisMonthPaidSalary() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter salary month: ");
            String month = scanner.nextLine();
            System.out.print("Enter salary year: ");
            int year = getUserInput();
            String show = "SELECT SUM(payment_amount) AS total_payment FROM salary_paid WHERE month = ? AND year = ?";
            PreparedStatement pstmt = conn.prepareStatement(show);
            pstmt.setString(1, month);
            pstmt.setInt(2, year);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Total payment: " + rs.getInt("total_payment"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void departmentAllEmployees() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter department name: ");
            String Dept_name = scanner.nextLine();
            String show = "SELECT * FROM employee NATURAL JOIN department NATURAL JOIN emp_dept WHERE Dept_name = ?";
            PreparedStatement pstmt = conn.prepareStatement(show);
            pstmt.setString(1, Dept_name);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Emp_id: " + rs.getInt("Emp_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Salary: " + rs.getInt("salary"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("Role: " + rs.getString("role"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void deptManager() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter department name: ");
            String Dept_name = scanner.nextLine();
            String show = "SELECT * FROM employee NATURAL JOIN manager NATURAL JOIN department WHERE Dept_name = ?";
            PreparedStatement pstmt = conn.prepareStatement(show);
            pstmt.setString(1, Dept_name);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Emp_id: " + rs.getInt("Emp_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Salary: " + rs.getInt("salary"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("Role: " + rs.getString("role"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void deptEmpSoftware() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter software name: ");
            String soft_name = scanner.nextLine();
            String show = "SELECT * FROM employee NATURAL JOIN software_gallery NATURAL JOIN emp_dept WHERE soft_name = ?";
            PreparedStatement pstmt = conn.prepareStatement(show);
            pstmt.setString(1, soft_name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Emp_id: " + rs.getInt("Emp_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Dept_id: " + rs.getInt("Dept_id"));
                System.out.println("Dept_name: " + rs.getString("Dept_name"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void completeSoftwareList() throws SQLException {
        try {
            String show = "SELECT soft_name FROM software_gallery WHERE status = 'complete'";
            PreparedStatement pstmt = conn.prepareStatement(show);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Soft_name: " + rs.getString("soft_name"));

                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void incompleteSoftwareList() throws SQLException {
        try {
            String show = "SELECT soft_name FROM software_gallery WHERE status = 'incomplete'";
            PreparedStatement pstmt = conn.prepareStatement(show);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Soft_name: " + rs.getString("soft_name"));

                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void highestEmployeeSalary() throws SQLException {
        try {
            String show = "SELECT name, MAX(salary) AS max_salary FROM employee";
            PreparedStatement pstmt = conn.prepareStatement(show);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Max_salary: " + rs.getInt("max_salary"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void totalEmployeesEachDepartment() throws SQLException {
        try {
            String show = "SELECT Dept_name, COUNT(Emp_id) AS total_employees FROM department NATURAL JOIN emp_dept GROUP BY Dept_name";
            PreparedStatement pstmt = conn.prepareStatement(show);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Dept_name: " + rs.getString("Dept_name"));
                System.out.println("Total_employees: " + rs.getInt("total_employees"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void lastMonthSalary() throws SQLException {
        try {
            String show = "SELECT SUM(payment_amount) AS total_payment FROM salary_paid WHERE month = MONTHNAME(CURDATE() - INTERVAL 1 MONTH) AND year = YEAR(CURDATE() - INTERVAL 1 MONTH)";
            PreparedStatement pstmt = conn.prepareStatement(show);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Total payment: " + rs.getInt("total_payment"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void highestSellingSoftwareTotalAmount() throws SQLException {
        try {
            String show = "SELECT soft_name, MAX(price) AS max_price FROM software_sell";
            PreparedStatement pstmt = conn.prepareStatement(show);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Soft_name: " + rs.getString("soft_name"));
                System.out.println("Max_price: " + rs.getInt("max_price"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void totalSoftwareSoldEachMonth() throws SQLException {
        try {
            String show = "SELECT MONTHNAME(sell_time) AS month, COUNT(soft_name) AS total_sold FROM software_sell WHERE status = 'complete' GROUP BY MONTHNAME(sell_time)";
            PreparedStatement pstmt = conn.prepareStatement(show);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Month: " + rs.getDate("month"));
                System.out.println("Total_sold: " + rs.getInt("total_sold"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void employeesNotInProjects() throws SQLException {
        try {
            String show = "SELECT name FROM employee WHERE Emp_id NOT IN (SELECT Emp_id FROM project_employee)";
            PreparedStatement pstmt = conn.prepareStatement(show);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void employeesInProjects() throws SQLException {
        try {
            String show = "SELECT name FROM employee WHERE Emp_id IN (SELECT Emp_id FROM project_employee)";
            PreparedStatement pstmt = conn.prepareStatement(show);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void projectLeaderInformation() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter project name: ");
            String proj_name = scanner.nextLine();
            String show = "SELECT * \n" +
                    "FROM employee \n" +
                    "INNER JOIN project \n" +
                    "ON project.leader_id = employee.Emp_id \n" +
                    "WHERE proj_name =  ? " +
                    ";";
            PreparedStatement pstmt = conn.prepareStatement(show);
            pstmt.setString(1, proj_name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Emp_id: " + rs.getInt("Emp_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Proj_id: " + rs.getInt("proj_id"));
                System.out.println("Proj_name: " + rs.getString("proj_name"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void updateEmployeeReview() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter employee ID: ");
            int Emp_id = getUserInput();
            System.out.print("Enter new review score: ");
            int review = getUserInput();
            String update = "UPDATE employee_review SET review = ? WHERE Emp_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(update);
            pstmt.setInt(1, review);
            pstmt.setInt(2, Emp_id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Review updated successfully.");
            } else {
                System.out.println("Error updating review.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void specificRoleAllEmployees() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter role: ");
            String role = scanner.nextLine();
            String show = "SELECT * FROM employee WHERE role = ?";
            PreparedStatement pstmt = conn.prepareStatement(show);
            pstmt.setString(1, role);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Emp_id: " + rs.getInt("Emp_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Salary: " + rs.getInt("salary"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("Role: " + rs.getString("role"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void whichSellerBoughtHighestSoftware() throws SQLException {
        try {
            String show = "SELECT sell_institute, COUNT(soft_name) AS total_software FROM software_sell GROUP BY sell_institute ORDER BY total_software DESC LIMIT 1";
            PreparedStatement pstmt = conn.prepareStatement(show);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Sell_institute: " + rs.getString("sell_institute"));
                System.out.println("Total_software: " + rs.getInt("total_software"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void specificProjectEmployees() {
        try {
            System.out.print("Enter previous project code: ");
            int proj_code = getUserInput();

            String query = "SELECT e.Emp_id, e.name, e.role " +
                    "FROM employee e " +
                    "JOIN project_employee pe ON e.Emp_id = pe.Emp_id " +
                    "WHERE pe.proj_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, proj_code);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Emp_id: " + rs.getInt("Emp_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Role: " + rs.getString("role"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }

    private static void showSpecificMonthSalary() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter employee id: ");
            int id = getUserInput();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter salary month: ");
            String month = scanner.nextLine();

            String query = "SELECT * FROM salary_paid WHERE Emp_id = ? AND month = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, month);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Payment Amount: " + rs.getInt("payment_amount"));
                System.out.println("Date: " + rs.getString("date"));
                System.out.println("Month: " + rs.getString("month"));
                System.out.println("Year: " + rs.getInt("year"));
                System.out.println("Payment Type: " + rs.getString("payment_type"));
                System.out.println("Emp_id: " + rs.getInt("Emp_id"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        waitForAction();
    }
}
