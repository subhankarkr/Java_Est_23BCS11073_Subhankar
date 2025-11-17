
import java.util.Scanner;
import java.sql.*;
public class Employee {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "Subhankar"; 

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database successfully!");

            
            String insertQuery = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertQuery);

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            int salary = sc.nextInt();

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, salary);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " record inserted successfully!");

            System.out.println("\nEmployee Records:");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Salary: " + rs.getInt("salary"));
            }

            rs.close();
            stmt.close();
            pstmt.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
