<%--
  Created by IntelliJ IDEA.
  User: ZPOG9-002
  Date: 2024-06-14
  Time: 오후 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>board</div>
    <c:forEach var="item" items="${testData}">
        <tr>
            <td>${item.searchId}</td>
            <td>${item.content}</td>
        </tr>
    </c:forEach>
</body>
</html>
