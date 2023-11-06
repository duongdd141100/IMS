<%-- 
    Document   : create
    Created on : Nov 6, 2023, 6:56:45 PM
    Author     : Do Duc Duong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="view/project_management/index.css">
    </head>
    <body>
        <form id="project-form" action="list-class" method="POST">
            <div class="detail">
                <div class="detail-title">Name</div>
                <input class="input input-text" type="text" name="name" id="name" value="${project.name}">
            </div>
            <div class="detail">
                <div class="detail-title">Teacher</div>
                <select name="teacherId" class="input input-text">
                    <c:forEach items="${teachers}" var="s">
                        <option 
                            value="${s.id}">${s.username}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="detail">
                <div class="detail-title">Subject</div>
                <select name="subjectId" class="input input-text">
                    <c:forEach items="${subjects}" var="s">
                        <option 
                            value="${s.subject_id}">${s.subject_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="detail">
                <div class="detail-title">Semester</div>
                <select name="semesterId" class="input input-text">
                    <c:forEach items="${semesters}" var="s">
                        <option
                            value="${s.setting_id}">${s.setting_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="detail detail-description">
                <div class="detail-title-description">Description</div>
                <textarea class="input input-text-area" rows="4" cols="50" id="description">${project.description}</textarea>
            </div>
            <input type="hidden" id="input-description" name="description" value="${project.description}">
            <input type="hidden" name="action" value="CREATE">
            </form>
            <div class="btn-container"><button class="btn-update" onclick="onFormSubmit()" >Create</button></div>
    </body>
</html>

<script>
    const onFormSubmit = () => {
        document.getElementById('input-description').value = document.getElementById('description').value;
        document.getElementById('project-form').submit();
    }
</script>