<%@ page import="com.jsp.jsp_board.DTO.BoardDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="assets/js/script.js"></script>
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
<%--<jsp:include page="component/header/index.jsp" />--%>
<%--<jsp:include page="component/main/index.jsp" />--%>

<table border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>Title</th>
        <th>Content</th>
        <th>Category</th>
        <th>Sub Category</th>
        <th>Hits</th>
        <th>Recommend</th>
        <th>Create Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${boardData}">
        <tr>
            <td>${item.boardId}</td>
            <td>${item.title}</td>
            <td>${item.content}</td>
            <td>${item.category}</td>
            <td>${item.subCategory}</td>
            <td>${item.hits}</td>
            <td>${item.recommend}</td>
            <td>${item.createDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="t">test Servlet</a>
<div>
    <a href="b">board Servlet</a>
</div>
</body>
</html>
