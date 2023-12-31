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
        <h1>Class Detail</h1>
        <form id="project-form" action="list-class" method="POST">
            <div class="detail">
                <div class="detail-title">ID</div>
                <input class="input input-text" type="text" name="id" id="name" value="${classDetail.class_id}" readonly>
            </div>
            <div class="detail">
                <div class="detail-title">Name</div>
                <input class="input input-text" type="text" name="name" id="name" value="${classDetail.class_name}">
            </div>
            <div class="detail">
                <div class="detail-title">Teacher</div>
                <select name="teacherId" class="input input-text">
                    <c:forEach items="${teachers}" var="s">
                        <option 
                            <c:if test="${s.id == classDetail.teacher_id}">selected</c:if>
                            value="${s.id}">${s.username}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="detail">
                <div class="detail-title">Subject</div>
                <select name="subjectId" class="input input-text">
                    <c:forEach items="${subjects}" var="s">
                        <option 
                            <c:if test="${s.subject_id == classDetail.subject_id}">selected</c:if>
                            value="${s.subject_id}">${s.subject_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="detail">
                <div class="detail-title">Semester</div>
                <select name="semesterId" class="input input-text">
                    <c:forEach items="${semesters}" var="s">
                        <option
                            <c:if test="${s.setting_id == classDetail.semester_id}">selected</c:if>
                            value="${s.setting_id}">${s.setting_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="detail detail-description">
                <div class="detail-title-description">Description</div>
                <textarea class="input input-text-area" rows="4" cols="50" id="description">${project.description}</textarea>
            </div>
            <input type="hidden" id="input-description" name="description" value="${project.description}">
            <input type="hidden" name="action" value="UPDATE" >
        </form>
            <div class="btn-container"><button class="btn-update" onclick="onFormSubmit()" >Update</button></div>
            
            <a href="list-class">Back to list</a>
    </body>
</html>
<script>
    const onFormSubmit = () => {
        document.getElementById('input-description').value = document.getElementById('description').value;
        document.getElementById('project-form').submit()
    }
</script>
