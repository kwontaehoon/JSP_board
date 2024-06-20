<%--
  Created by IntelliJ IDEA.
  User: ZPOG9-002
  Date: 2024-06-10
  Time: 오후 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="my-5 bg-[#FFB93D] flex px-5 items-center">
        <div class="flex-1 font-bold text-xl">JSP 게시판</div>
        <img src="assets/images/banner-pengu.png"/>
    </div>
    <div class="my-5 flex gap-2">
        <%
            for(int i=0; i<3; i++){
        %>
        <div class="px-2 py-1 bg-black text-white text-xs rounded">인기 게시판</div>
        <%
            }
        %>
    </div>
    <div class="my-5 flex items-center">
        <div class="flex-1 flex gap-2">
        <%
            for(int i=0; i<2; i++){
        %>
        <div class="px-2 py-1 bg-[#DC3545] text-white text-xs rounded">모든글</div>
        <%
            }
        %>
        </div>
        <a href="/login" class="text-xs bg-green-500 rounded px-2 py-1 text-white">로그인</a>
    </div>
</body>
</html>
