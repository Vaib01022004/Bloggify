/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author root
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JDBCUserDAO {

    /**
     *
     * @param email
     * @return
     */
    
    private static final String url= "jdbc:mysql://localhost:3306/bloggify";
    private static final String username = "root";
    private static final String PASSWORD = "admin";
    
    public User getUserByEmail(String email){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(Connection conn = DriverManager.getConnection(url,username,PASSWORD)){ 
            String sql = "SELECT * FROM users WHERE email = ?";
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1,email);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    String name = rs.getString("name");
                    String Email = rs.getString("email");
                    String password = rs.getString("password");
                    return new User(name,Email,password);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    
   public int createUser(User user) {
        try (Connection conn = DriverManager.getConnection(url, username, PASSWORD)) {
            String sql = "INSERT INTO users (email, password, name) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, user.getEmail());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getName());
                int i = stmt.executeUpdate();
                return i;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
 
}
