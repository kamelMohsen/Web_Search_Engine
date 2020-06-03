import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class suggestions extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException
    {
        String input = request.getParameter("textbox");
        response.setContentType("application/json");
         String docType = null;
        response.getWriter().print(docType);

    }
}
