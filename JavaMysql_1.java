// package java_sql;
import java.sql.*;
import java.util.Scanner;

public class JavaMysql_1 {
    public static void add_student(Connection conn){
        System.out.println("in function add_student");
        // here i want the insert command
        try{
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the student name:");
            String name=sc.nextLine();
            String sql ="INSERT INTO students(name) VALUES (?)";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,name);
            int rows=stmt.executeUpdate();
            if(rows>0)
            {
                System.out.println("Student added successfully");
            }
            else{
                System.out.println("Failed to add student");
            }
            stmt.close();
            sc.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error inserting student: "+e.getMessage());
        }
    }
    public static void add_course(Connection conn){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the course name:");
            String title=sc.nextLine();
            String sql="insert into courses(title) values(?)";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,title);
            int rows=stmt.executeUpdate();
            if(rows>0)
            {
                System.out.println("Course name added successfully");
            }
            else{
                System.out.println("Failes to add the course");
            }
            stmt.close();
            sc.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error in inserting course: "+e.getMessage());
        }
    }
    // public static void enroll_student_to_course(Connection conn)
    // {
    //     /*
    //      * so first ask which student want to enroll,
    //      * get a name as input 
    //      * if name does'nt exists then try another person, 
    //      * if exists it saves as variable
    //      * then ask which course want to enroll same as above we do it
    //      * then add into it
    //      */
    //     try{
    //         Scanner sc=new Scanner(System.in);
    //         System.out.println("Enter the student name:");
    //         String name=sc.nextLine();
    //         System.out.println("Enter the course name:");
    //         String course=sc.nextLine();

    //         String sql="insert into "

    //     }
    // }
    public static void view_all_students(Connection conn)
    {
        try{
            String sql="select * from students";
            Statement stmt=conn.createStatement();

            ResultSet rs=stmt.executeQuery(sql);
            int x=0;
            while(rs.next())
            { 
                x=x+1;
                String name=rs.getString("name");
                System.out.println(x+": "+name);
            }
            rs.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error in listing names: "+e.getMessage());
        }
    }
    public static void view_all_courses(Connection conn)
    {
        try{
            String sql="select * from courses";
            Statement stmt=conn.createStatement();

            ResultSet rs=stmt.executeQuery(sql);
            int x=0;
            while(rs.next())
            {
                x=x+1;
                String course_name=rs.getString("title");
                System.out.println(x+" :"+course_name);
            }
            rs.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error in listing course: "+e.getMessage());
        }
    }
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = "MyNewPass";
        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection done successfully!");

            System.out.println(
                "📋 Main Menu\n" +
                "1. Add Student\n" +
                "2. Add Course\n" +
                "3. Enroll Student in Course\n" +
                "4. View All Students\n" +
                "5. View All Courses\n" +
                "6. View All Enrollments\n"+
                "7. Exit"
            );

            Scanner sc = new Scanner(System.in);
            System.out.println("Take one option from the above list: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    add_student(conn); // make sure this method exists
                    break;
                case 2:
                    add_course(conn);
                    break;
                // case 3:
                //     enroll_student_to_course(conn);
                //     break;
                case 4:
                    view_all_students(conn);
                    break;
                case 5:
                    view_all_courses(conn);
                    break;
                case 7:System.out.println("Exited..!");
                break;
                default:
                    System.out.println("exit");

            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
