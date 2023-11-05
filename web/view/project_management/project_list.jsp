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
        <div class="table-container">
            <table>
                <tr class="project-tr">
                    <th>Project ID</th>
                    <th>Project Name</th>
                    <th>Class</th>
                    <th>Leader</th>
                    <th>Description</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${projects}" var="p">
                    <tr class="project-tr" onclick="onViewProjectDetail('${p.id}')">
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>${p.className}</td>
                        <td>${p.leaderName}</td>
                        <td>${p.description}</td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td></td>
                        <td><input name="name" type="text" placeholder="Name" ></td>
                        <td><input name="className" type="text" placeholder="Name" ></td>
                        <td><input name="name" type="text" placeholder="Name" ></td>
                        <td><input name="description" type="text" placeholder="description" ></td>
                        <td><button>Create</button></td>
                    </tr>
        </table>
        </div>
    </body>
</html>
<script>
    const onViewProjectDetail = (id) => {
        window.location.href = 'projects?view=DETAIL&id=' + id;
    }
</script>
