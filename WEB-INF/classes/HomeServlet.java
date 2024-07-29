import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import imp.Blog;
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get email from session attribute
        String email = (String) request.getSession().getAttribute("uname");
        
        // Retrieve blogs for the user
        JDBCBlogDAO blogDAO = new JDBCBlogDAO();
        try {
            List<Blog> blogs = blogDAO.getBlogsByEmail(email);
            request.setAttribute("blogs", blogs);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
            // Forward to an error page or handle appropriately
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
