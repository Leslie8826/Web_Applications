import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class DatabaseAccess extends HttpServlet{

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	   Connection conn = null;
	   Statement stmt = null;
	   
      // JDBC driver definition 
	  final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
      final String DB_URL="jdbc:mysql://localhost:3306/test_for_select"; // test_for_select is the name of the database
      
      // Information of Database
      final String USER = "root";
      final String PASS = "put password here";
      
      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
    
      out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor = \"#f0f0f0\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n");
      
      try {
         // Load a JDBC driver implementation
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection to mysql database
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL select query
         stmt = conn.createStatement();
         String sql;
         sql = "SELECT id, firstName, lastName, yearlySalary FROM Employees";
         ResultSet rs = stmt.executeQuery(sql);

         // Extract data from result set
         while(rs.next()){
            //column name
            int id  = rs.getInt("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            int yearlySalary = rs.getInt("yearlySalary");
 
            out.println("<br> ID: " + id + " ");
            out.println(", First Name: " + firstName + " ");
            out.println(", Last Name: " + lastName + " ");
            out.println(", Yearly Salary: " + yearlySalary + "<br>");
         }
         out.println("</body></html>");

         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } catch(SQLException se) {
         se.printStackTrace();
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(stmt != null)
               stmt.close();
         } catch(SQLException se2) {
         }
         try {
            if(conn!=null)
            conn.close();
         } catch(SQLException se) {
            se.printStackTrace();
         }
      }
   }
} 
