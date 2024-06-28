<%--
  Created by IntelliJ IDEA.
  User: ZPOG9-002
  Date: 2024-06-10
  Time: 오후 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="h-[300px] border">
        <div class="flex text-center py-3 text-xs md:text-sm border-b">
            <div class="w-1/4">#</div>
            <div class="w-1/4">제목</div>
            <div class="w-1/4">닉네임</div>
            <div class="w-1/4">날짜</div>
        </div>
        <c:forEach var="item" items="${boardList}">
            <div class="border-b flex py-3 text-center bg-[#AOAOAO] text-xs md:text-sm">
                <div class="w-1/4">${item.boardId}</div>
                <div class="w-1/4">${item.content}</div>
                <div class="w-1/4">${item.name}</div>
                <div class="w-1/4">${item.createDate}</div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
