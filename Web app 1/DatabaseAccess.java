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
	   
      // JDBC driver name and database URL 
	  final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
      final String DB_URL="jdbc:mysql://localhost:3306/test_for_select";
      
      //  Database credentials
      final String USER = "root";
      final String PASS = "MySQL_021282";
      
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
      
           
    /*  String docType =
              "<!doctype html" +
              "transitional//en\">\n";
              out.println(docType +
              "<html>\n" +
              "<head><title>" + title + "</title></head>\n" +
              "<body>");*/
       
      
      try {
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         //Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         stmt = conn.createStatement();
         String sql;
         sql = "SELECT id, firstName, lastName, yearlySalary FROM Employees";
         ResultSet rs = stmt.executeQuery(sql);

         // Extract data from result set
         while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            int yearlySalary = rs.getInt("yearlySalary");

            //Display values
            /*out.println("ID: " + id + "<br>");
            out.println(", First Name: " + firstName + "<br>");
            out.println(", Last Name: " + lastName + "<br>");
            out.println(", Yearly Salary: " + yearlySalary + "<br>");*/
            
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
         //Handle errors for JDBC
         se.printStackTrace();
      } catch(Exception e) {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally {
         //finally block used to close resources
         try {
            if(stmt != null)
               stmt.close();
         } catch(SQLException se2) {
         } // nothing we can do
         try {
            if(conn!=null)
            conn.close();
         } catch(SQLException se) {
            se.printStackTrace();
         } //end finally try
      } //end try
   }
} 
