import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


public class Interface extends HttpServlet {
 public String userInput = "wikii is the koko";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException
    {
        //To extract the text entered by the user
        userInput = request.getParameter("textbox");

      //Sending data to query processor

      //Receiving data from query processor


      //To print the page on screen
        //1. set page content
        response.setContentType("application/json");

        //2.Design the page
         String page = "<!doctype html> <html> <body> <h1>" + userInput + "</h1> </body> </html>" ;
       //3. Dispaly page's content
        response.getWriter().print(page);
    }

}
