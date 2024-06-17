<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test JSP Page</title>
</head>
<body>
<h1>Board Data</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Content</th>
    </tr>
    <c:forEach var="item" items="${testData}">
        <tr>
            <td>${item.searchId}</td>
            <td>${item.content}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
