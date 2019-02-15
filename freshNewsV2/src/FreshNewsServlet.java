import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FreshNewsV2")
public class FreshNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");

        String number = request.getParameter("number");
        ContentGetter contentObj = new ContentGetter(Integer.parseInt(number));
        try {
            contentObj.setContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String hed = new String(contentObj.getHead().getBytes(), "UTF-8");
        String bod = new String(contentObj.getBody().getBytes(), "UTF-8");

        request.setAttribute("header", hed);
        request.setAttribute("body", bod);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }
}
