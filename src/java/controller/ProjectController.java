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
import service.ProjectService;
import service.impl.ProjectServiceImpl;

/**
 *
 * @author Do Duc Duong
 */
public class ProjectController extends HttpServlet {
    
    private ProjectService projectService = new ProjectServiceImpl();

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
            if (view == null || Constant.VIEW_ALL_ACTION.equals(view)) {
                request.setAttribute("projects", projectService.findAll());
                request.getRequestDispatcher("view/project_management/view.jsp").forward(request, response);
            } else if (Constant.VIEW_DETAIL_ACTION.equals(view)) {
                String id = request.getParameter("id");
                request.setAttribute("product", projectService.findById(Integer.parseInt(id)));
                request.getRequestDispatcher("view/project_management/detail.jsp").forward(request, response);
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
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String classId = request.getParameter("classId");
        String leaderId = request.getParameter("leaderId");
        String description = request.getParameter("leaderId");
        switch (action) {
            case Constant.CREATE_ACTION:
                projectService.create(name, Integer.parseInt(classId), Integer.parseInt(leaderId), description);
                break;
            case Constant.UPDATE_ACTION:
                projectService.update(Integer.parseInt(id), name, classId, leaderId, description);
            break;
            case Constant.DELETE_ACTION:
                projectService.delete(Integer.parseInt(id));
            break;
            default:
                throw new AssertionError();
        }
    }

}
