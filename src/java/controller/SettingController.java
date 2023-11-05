/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import common.Constant;
import dal.SettingDAL;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import modal.Setting;
import service.impl.SettingServiceImpl;

/**
 *
 * @author admin
 */
public class SettingController extends HttpServlet {

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
            out.println("<title>Servlet SettingController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SettingController at " + request.getContextPath() + "</h1>");
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
        try {
            String view = request.getParameter("view");
            System.out.println(view);
            if (view == null || Constant.VIEW_ALL_ACTION.equals(view)) {
                request.setAttribute("settings",new SettingDAL().getAll());
                request.getRequestDispatcher("view/system_setting/list.jsp").forward(request, response);
            } else if (Constant.VIEW_DETAIL_ACTION.equals(view)) {                 
                String id = request.getParameter("id");
                System.out.println(id);
                request.setAttribute("setting", new SettingDAL().getSettingById(id));
                System.out.println(new SettingDAL().getSettingById(id));
                request.getRequestDispatcher("view/system_setting/detail.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Please provide view action!");
                request.getRequestDispatcher("view/error/error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("view/error/error.jsp").forward(request, response);
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
        String message ="";
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String display_order = request.getParameter("display_order");
        String status = request.getParameter("status");
        String description = request.getParameter("description");         
        if (Constant.UPDATE_ACTION.equals(action)) {
            
            boolean updateSucess = new SettingServiceImpl(). updateSuccess(id, name, type, display_order, status, description);
            System.out.println(updateSucess);
            if (updateSucess) {
                message = "Update Success";
            }else {
                message = "Update Fail";             
            }
            request.setAttribute("message",message);
            request.setAttribute("settings",new SettingDAL().getAll());
            request.getRequestDispatcher("view/system_setting/list.jsp").forward(request, response);
        }else {
            boolean addnewSuccess = new SettingServiceImpl().addnewSuccess(name, type, display_order, status, description);
            System.out.println(addnewSuccess);
            if (addnewSuccess) {
                message = "Add New Success";
            }else {
                message = "Add New Fail";
            }   
            request.setAttribute("message",message);
            request.setAttribute("settings",new SettingDAL().getAll());
            request.getRequestDispatcher("view/system_setting/list.jsp").forward(request, response);
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
