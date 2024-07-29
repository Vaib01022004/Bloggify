import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import imp.Blog;

public class JDBCBlogDAO  {
    private static final String URL = "jdbc:mysql://localhost:3306/bloggify";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

   
    public int insertBlog(Blog blog) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO blogs (email, title, bdesc, category, body, cdate) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, blog.getEmail());
            statement.setString(2, blog.getTitle());
            statement.setString(3, blog.getBdesc());
            statement.setString(4, blog.getCategory());
            statement.setString(5, blog.getBody());
            statement.setDate(6, new java.sql.Date(blog.getCdate().getTime()));

            return statement.executeUpdate();
        }
    }
     public Blog getBlogByBid(int bid) throws SQLException {
        Blog blog = null;
        String query = "SELECT * FROM blogs WHERE bid = ?";
        
        // Create a connection
        try (Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Set the bid parameter in the query
            statement.setInt(1, bid);
            
            // Execute the query
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Extract blog data from the ResultSet
                    String email = resultSet.getString("email");
                    String title = resultSet.getString("title");
                    String bdesc = resultSet.getString("bdesc");
                    String category = resultSet.getString("category");
                    String body = resultSet.getString("body");
                    java.util.Date cdate = resultSet.getDate("cdate");
                    // Create a new Blog object
                    blog = new Blog(bid,email, title, category, bdesc, body,cdate);
                }
            }
        }
        return blog;
    }

    
    public List<Blog> getBlogsByEmail(String email) throws SQLException {
        List<Blog> blogs = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM blogs WHERE email = ?")) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int bid = resultSet.getInt("bid");
                    String title = resultSet.getString("title");
                    String bdesc = resultSet.getString("bdesc");
                    String category = resultSet.getString("category");
                    String body = resultSet.getString("body");
                    java.util.Date cdate = resultSet.getDate("cdate");

                    Blog blog = new Blog(bid, email, title, bdesc, category, body, cdate);
                    blogs.add(blog);
                }
            }
        }

        return blogs;
    }
}
