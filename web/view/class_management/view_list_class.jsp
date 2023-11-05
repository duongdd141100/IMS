
<%-- 
    Document   : view_list_class
    Created on : Nov 4, 2023, 9:33:31 PM
    Author     : User
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Class List</title>
    </head>
    <body>
        <h1>CLass List</h1>


        <form action="list-class" method="POST">

            <select name="semester" id="semester">
                <option id="0">All</option> 
                <c:forEach var="semester_list" items="${semester}">
                    <option id='${semester_list.setting_id}'>${semester_list.setting_name}</option>
                </c:forEach>
            </select>
            <select name="subject" id = "subject">
                <option id="0">All</option> 
                <c:forEach var="subject_list" items="${subject}">
                    <option id='${subject_list.subject_id}'>${subject_list.subject_name}</option>
                </c:forEach>
            </select>
            <select name="teacher" id = "teacher">
                <option id="0">All</option> 
                <c:forEach var="teacher_list" items="${teacher}">
                    <option id='${teacher_list.id}'>${teacher_list.username}</option>
                </c:forEach>
            </select>
            <select name="class" id = "class">
                <option id="0">All</option> 
                <c:forEach var="clas_list" items="${class_list}">
                    <option id = "${clas_list.class_id}">${clas_list.class_name}</option> 
                </c:forEach>
            </select>
            <input type="submit" value="search" name="action" />
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th></th>
                    <th>Class code</th>
                    <th>Semester</th>
                    <th>Subject</th>
                    <th>Teacher</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="clas_list" items="${class_list}">
                    <tr>
                        <td>${clas_list.class_id}</td>
                        <td>${clas_list.class_name}</td>
                        <td>
                            <c:forEach var="semester_list" items="${semester}">
                                <c:if test="${semester_list.setting_id == clas_list.semester_id}">
                                    ${semester_list.setting_name}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="subject_list" items="${subject}">
                                <c:if test="${subject_list.subject_id == clas_list.subject_id}">
                                    ${subject_list.subject_name}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="teacher_list" items="${teacher}">
                                <c:if test="${teacher_list.id == clas_list.teacher_id}">
                                    ${teacher_list.username}
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
