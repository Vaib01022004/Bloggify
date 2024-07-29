import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import imp.Blog;
@WebServlet("/CreateBlogServlet")
public class CreateBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String body = request.getParameter("body");
        String bdesc = request.getParameter("description");
        
        
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("uname");
        
       
        Date currentDate = new Date();
        
        
        Blog blog = new Blog(email, title, bdesc, category, body, currentDate);
        
        
        JDBCBlogDAO blogDAO = new JDBCBlogDAO();
        try {
            int rowsAffected = blogDAO.insertBlog(blog);
            if (rowsAffected > 0) {
              
                request.setAttribute("insertionSuccess", true);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                // Insertion failed
                // Set insertionSuccess attribute to false and forward to createBlog.jsp
                request.setAttribute("insertionSuccess", false);
                request.getRequestDispatcher("createBlog.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
            // Forward to an error page or handle appropriately
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
