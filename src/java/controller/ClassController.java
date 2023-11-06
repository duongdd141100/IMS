/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.Constant;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import modal.Setting;
import modal.User;
import service.ClassService;
import service.SettingService;
import service.SubjectService;
import service.UserService;
import service.impl.ClassServiceImpl;
import service.impl.SettingServiceImpl;
import service.impl.SubjectServiceImpl;
import service.impl.UserServiceImpl;

/**
 *
 * @author User
 */
public class ClassController extends HttpServlet {

    private final ClassService classService = new ClassServiceImpl();
    private final SettingService settingService = new SettingServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final SubjectService subjectService = new SubjectServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String view = request.getParameter("view");
            if (view == null || Constant.VIEW_ALL_ACTION.equals(view)) {
                request.setAttribute("teacher", userService.findAllTeacher());
                request.setAttribute("semester", settingService.findAllSemesterIsActive());
                request.setAttribute("class_list", classService.findAll());
                request.setAttribute("subject", subjectService.findAll());
                request.setAttribute("semesters", settingService.findAllSemesterIsActive());
                request.getRequestDispatcher("view/class_management/view_list_class.jsp").forward(request, response);
            } else if (Constant.VIEW_DETAIL_ACTION.equals(view)) {
                String id = request.getParameter("id");
                request.setAttribute("teachers", userService.findAllTeacher());
                request.setAttribute("subjects", subjectService.findAll());
                request.setAttribute("semesters", settingService.findAllSemesterIsActive());
                request.setAttribute("classDetail", classService.findById(Integer.parseInt(id)));
                request.getRequestDispatcher("view/class_management/detail_class.jsp").forward(request, response);
            } else if (Constant.CREATE_ACTION.equals(view)) {
                request.setAttribute("teachers", userService.findAllTeacher());
                request.setAttribute("subjects", subjectService.findAll());
                request.setAttribute("semesters", settingService.findAllSemesterIsActive());
                request.getRequestDispatcher("view/class_management/create.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Please provide view action!");
                request.getRequestDispatcher("view/error/error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("view/error/error.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            String semester = request.getParameter("semester");
            String teacher = request.getParameter("teacher");
            String subject = request.getParameter("subject");
            String class_name = request.getParameter("class");

            if (action.equals("search")) {
                request.setAttribute("teacher", userService.findAllTeacher());
                request.setAttribute("semester", settingService.findAllSemesterIsActive());
                request.setAttribute("subject", subjectService.findAll());
                request.setAttribute("class_list", classService.searchAll(semester, teacher, subject, class_name));
                request.getRequestDispatcher("view/class_management/view_list_class.jsp").forward(request, response);
            } else if (Constant.UPDATE_ACTION.equals(action)) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String subjectId = request.getParameter("subjectId");
                String teacherId = request.getParameter("teacherId");
                String semesterId = request.getParameter("semesterId");
                String description = request.getParameter("description");
                classService.update(id, name, subjectId, teacherId, semesterId, description);
                response.sendRedirect("list-class?view=DETAIL&id=" + id);
            } else if (Constant.CREATE_ACTION.equals(action)) {
                String name = request.getParameter("name");
                String subjectId = request.getParameter("subjectId");
                String teacherId = request.getParameter("teacherId");
                String semesterId = request.getParameter("semesterId");
                String description = request.getParameter("description");
                classService.create(name, subjectId, teacherId, semesterId, description);
                response.sendRedirect("list-class");
            } else {
                request.setAttribute("message", "Please provide action!");
                request.getRequestDispatcher("view/error/error.jsp");
            }
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("view/error/error.jsp");
        }
        
    }
}
