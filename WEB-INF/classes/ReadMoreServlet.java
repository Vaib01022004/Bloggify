import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import imp.Blog;
public class ReadMoreServlet extends HttpServlet {
    private JDBCBlogDAO jdbcBlogDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize JDBCUserDAO instance
        jdbcBlogDAO = new JDBCBlogDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the bid parameter from the request
        int bid = Integer.parseInt(request.getParameter("bid"));
        
        try {
            // Retrieve the Blog object using JDBCUserDAO
            Blog blog = jdbcBlogDAO.getBlogByBid(bid);
            
            // Set the retrieved Blog object as a request attribute
            request.setAttribute("blog", blog);
            
            // Forward the request to the ReadMore.jsp for displaying the blog content
            request.getRequestDispatcher("/ReadMore.jsp").forward(request, response);
        } catch (SQLException e) {
            // Handle database errors
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
