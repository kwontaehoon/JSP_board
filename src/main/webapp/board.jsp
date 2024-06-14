<%--
  Created by IntelliJ IDEA.
  User: ZPOG9-002
  Date: 2024-06-14
  Time: 오후 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>board sql</div>
<%
    while (boardData.next()) {
        int id = boardData.getInt("id");
        String title = boardData.getString("title");
        String content = boardData.getString("content");
        String author = boardData.getString("author");
        String timestamp = boardData.getTimestamp("timestamp").toString();
%>
</body>
</html>
