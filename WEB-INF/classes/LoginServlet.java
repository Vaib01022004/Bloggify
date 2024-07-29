/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
public class LoginServlet extends HttpServlet {
    
    private JDBCUserDAO userDAO;
    @Override
    public void init(){
        userDAO = new JDBCUserDAO();
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        String email = request.getParameter("email");
        String password  = request.getParameter("password");
        User user = userDAO.getUserByEmail(email);
        if(user==null){
            request.setAttribute("error", "Account does not exist!");
            request.getRequestDispatcher("index.jsp").forward(request, response);   
        }
        else if(!user.getPassword().equals(password)){
            request.setAttribute("error","Incorrect Password!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
            
            
        }
        else{
            HttpSession session = request.getSession();
            session.setAttribute("uname", user.getEmail());
            response.sendRedirect("home.jsp");
        }
    }
}
