import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class MySQL {

    public static Connection getConnection() throws Exception{
        final String driver = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/qlsv";
        final String USER = "root";
        final String PASS = "1234567";
        Connection conn = null;

        try {
            Class.forName(driver);
            System.out.println(1);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  conn;
    }


    public static void addStudent(String mssv,String name, String gtinh, int tuoi, float dtb) {
        Connection conn = null;
        Statement stmt = null;
        try {

            System.out.println("Connecting to database...");
            conn = getConnection();

            System.out.println("Inserting records into the table...");
            String sql = " insert into Student (mssv, name, gtinh, tuoi, DTB)"
                    + " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, mssv);
            preparedStmt.setString (2, name);
            preparedStmt.setString (3, gtinh);
            preparedStmt.setInt    (4, tuoi);
            preparedStmt.setFloat(5,dtb);
            preparedStmt.execute();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void delete(String mssv) {
        Connection conn = null;
        Statement stmt = null;
        try {

            System.out.println("Connecting to database...");
            conn = getConnection();

            System.out.println("Delete records into the table...");
            String sql = "delete from student where mssv = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, mssv);

            preparedStmt.execute();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    public static void update(String mssv,String name, String gtinh, int tuoi, float dtb) {
        Connection conn = null;
        Statement stmt = null;
        try {

            System.out.println("Connecting to database...");
            conn = getConnection();

            System.out.println("Updating records into the table...");
            String sql = "UPDATE Student SET name = ?, gtinh = ?, tuoi = ?, DTB = ? WHERE mssv = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, name);
            preparedStmt.setString (2, gtinh);
            preparedStmt.setInt (3, tuoi);
            preparedStmt.setFloat    (4, dtb);
            preparedStmt.setString(5,mssv);
            preparedStmt.execute();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    public static List<Student> addStudentFromDTB(){
        List <Student> listStudent  = new ArrayList<Student>();
        try {   
            Connection conn = getConnection();
            String query = "SELECT * FROM Student";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Student stu = new Student(
                        rs.getString("mssv"),
                        rs.getString("name"),
                        rs.getString("gtinh"),
                        rs.getInt("tuoi"),
                        rs.getFloat("DTB")
                );
                listStudent.add(stu);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return  listStudent;
    }

    public  static void PrintListStudent(List<Student> list){
        for (Student st: list) {
            String info = st.toString();
            System.out.println(info);
        }
    }

//    public static void main(String[] args) {
//        List <Student> listStudent  = new ArrayList<Student>();
//        listStudent = addStudentFromDTB();
//        PrintListStudent(listStudent);
//
//
//
//    }




}
