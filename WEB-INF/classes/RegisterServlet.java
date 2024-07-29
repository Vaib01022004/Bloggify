/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
public class RegisterServlet extends HttpServlet {
    private JDBCUserDAO userDAO;
    private User user;
    private User userc;
    private int i = 0;
    public void init(){
        userDAO= new JDBCUserDAO();
        user = null;
        userc= null;
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(name,email,password);
        User userc = userDAO.getUserByEmail(email);
        if(userc!=null){
            request.setAttribute("rerror","Account already exists. Please Log In to continue!");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
            response.sendRedirect("index.jsp");
        }
        else{
            int i = userDAO.createUser(user);
            if(i>0){
                request.setAttribute("rsuccess","Account created successfully, Log In to continue!");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
                response.sendRedirect("index.jsp");
            }
        }
    }
   
}