/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import common.Constant;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.User;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 *
 * @author giang
 */
public class UserController extends HttpServlet {
    String message;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (Constant.LOGIN_ACTION.equals(action)) {
            request.getRequestDispatcher("view/user_authen/userlogin.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("view/user_authen/userregister.jsp").forward(request, response);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if (action.equals(Constant.REGISTER_ACTION)) {
            String fullname = request.getParameter("fullname");
            String birthday = request.getParameter("birthday");
            String address = request.getParameter("address");
            String username = request.getParameter("emailOrMobile");
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");           
            boolean register = new UserServiceImpl().registerSuccess(fullname, birthday, address, username, password, repassword);
            if(register) {              
                message = "Register success";
                request.setAttribute("message", message);
                request.getRequestDispatcher("view/user_authen/userlogin.jsp").forward(request, response);               
            }else {
                message = "Invalid information";
                request.setAttribute("message", message);
                request.getRequestDispatcher("view/user_authen/userregister.jsp").forward(request, response);
            }
        }else if(action.equals(Constant.LOGIN_ACTION)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println(username + " " + password);
            User user = new UserServiceImpl().userLogin(username, password);
            System.out.println(user);
            if(user.getId()!= 0) {
                message = "Login success";
                request.setAttribute("message", message);
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("view/user_authen/authorization.jsp").forward(request, response);               
            }else {
                message = "Invalid information";
                request.setAttribute("message", message);
                request.getRequestDispatcher("view/user_authen/userlogin.jsp").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
