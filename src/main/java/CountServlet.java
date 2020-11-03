import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "CounterServlet", urlPatterns = "/count") //setting up url
public class CounterServlet extends HttpServlet { //class declaration extends HttpServlet class
    private int counter = 0; //declare a private int named counter
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException { //set up doGet method
        counter +=1; //increment counter
        response.getWriter().println("<h1>The count is " + counter + "</h1>"); //Print html message displaying counter
    }
}
