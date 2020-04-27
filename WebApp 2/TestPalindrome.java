import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class TestPalindrome extends HttpServlet {
	public boolean isPalindrome(String x) {
		int res = 0;
		
		for(int i=0; i<x.length(); i++) {
			if(x.charAt(i) == x.charAt(x.length()-i-1)) {
				res = res + 1;
			}
		}
		
		if(res == x.length()) {
			return true;
		} else {
			return false;
		}	
	}
	
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message
      response.setContentType("text/html; charset=UTF-8");
      
      // Write the response message into the network socket
      PrintWriter out = response.getWriter();
 
      // Write the response message in a HTML page
      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Palindrome Test</title></head>");
         out.println("<body><h2>Palindrome Finder</h2>");
 
         // Retrieve the value of the parameter "word" 
         String word = request.getParameter("word");
        
         // if word is null, MISSING will be printing
         if (word == null
               || (word = htmlFilter(word.trim())).length() == 0) {
            out.println("<p> Word: MISSING </p>");
         } else {
            out.println("<p> Word: " + word + "</p>");
         }
 
      // Creates testPal object
         TestPalindrome testPal = new TestPalindrome();
          out.println("<p> Is " + word + " a palindrome? " + testPal.isPalindrome(word) + "</p>");

         // Hyperlink "BACK" to go back to previous page
         out.println("<a href='form_input.html'>BACK</a>");
         out.println("</body></html>");
      } finally {
         out.close();  // Always close the output writer
      }
   }
 
   // Redirect POST request to GET request
   public void doPost(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      doGet(request, response);
   }
 
   // Filter the string for special HTML characters
   private static String htmlFilter(String message) {
      if (message == null) return null;
      int l = message.length();
      StringBuffer result = new StringBuffer(l + 20);
      char aa;
 
      for (int i = 0; i < len; ++i) {
         aa = message.charAt(i);
    	  
         switch (aa) {
             case '<': result.append("&lt;"); break;
             case '>': result.append("&gt;"); break;
             case '&': result.append("&amp;"); break;
             case '"': result.append("&quot;"); break;
             default: result.append(aa);
         }
      }
      return (result.toString());
      
   }
}



