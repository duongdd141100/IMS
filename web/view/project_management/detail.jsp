<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="view/project_management/index.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="details-container">
            <form id="project-form" action="projects" method="POST">
            <div class="detail">
                <div class="detail-title">ID</div>
                <input class="input input-text" type="text" name="id" value="${project.id}" readonly>
            </div>
            <div class="detail">
                <div class="detail-title">Name</div>
                <input class="input input-text" type="text" name="name" id="name" value="${project.name}">
            </div>
            <div class="detail">
                <div class="detail-title">ClassName</div>
                <input class="input input-text" type="text" id="className" value="${project.className}" readonly>
                <input class="input input-text" type="hidden" name="classId" id="classId" value="${project.classId}">
            </div>
            <div class="detail">
                <div class="detail-title">Leader</div>
                <select name="leaderId" class="input input-text">
                    <c:forEach items="${studentsInProject}" var="s">
                        <option 
                            <c:if test="${s.id == project.leaderId}">
                                selected
                            </c:if>
                            value="${s.id}">${s.fullName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="detail detail-description">
                <div class="detail-title-description">Description</div>
                <textarea class="input input-text-area" rows="4" cols="50" id="description">${project.description}</textarea>
            </div>
            <input type="hidden" id="input-description" name="description" value="${project.description}">
            <input type="hidden" name="action" value="UPDATE">
            </form>
            <div class="btn-container"><button class="btn-update" onclick="onFormSubmit()" >Update</button></div>
            <div class="table-container">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Student Name</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${studentsInProject}" var="p">
                    <form action="projects" method="POST">
                        <tr id="tr-in">
                            <input type="hidden" name="id" value="${project.id}" >
                            <input type="hidden" name="studentId" value="${p.id}" >
                            <td>${p.id}</td>
                            <td>${p.fullName}</td>
                            <td><input type="submit" class="remove" value="Remove"
                                       <c:if test="${p.id == project.leaderId}">disabled</c:if>
                                       ></td>
                            <input value="MOVE_OUT" name="action" type="hidden">
                        </tr>
                    </form>
                </c:forEach>
                <c:forEach items="${studentsInClassNotInProject}" var="s">
                    <form action="projects" method="POST">
                        <tr id="tr-out">
                            <input type="hidden" name="id" value="${project.id}" >
                            <input type="hidden" name="studentId" value="${s.id}" >
                            <td>${s.id}</td>
                            <td>${s.fullName}</td>
                            <td><input type="submit" class="add" value="Add" ></td>
                            <input value="MOVE_IN" name="action" type="hidden">
                        </tr>
                    </form>
                </c:forEach>
            </table>
            </div>
        </div>
    </body>
</html>
<script>
    const onFormSubmit = () => {
        document.getElementById('input-description').value = document.getElementById('description').value;
        document.getElementById('project-form').submit()
    }
</script>
