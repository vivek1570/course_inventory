import java.sql.*;

public class MySQLConnect {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "javauser";
        String password = "javapass";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL database!");

            String query = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("👥 Users Table:");
            while (rs.next()) {
                int id = rs.getInt("id");               // column 1: id
                String name = rs.getString("name");     // column 2: name
                System.out.println("ID: " + id + ", Name: " + name);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
