import java.sql.*;

public class SQLiteExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:sample.db";  // path to DB file

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to the database.");

                String query = "SELECT * FROM users";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Age: " + rs.getInt("age"));
                    System.out.println("---");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
