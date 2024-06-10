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
    <div class="my-5 bg-[#FFB93D] p-5 font-bold text-lg">CRUD 게시판</div>
    <div class="my-5 flex">
        <%
            for(int i=0; i<3; i++){
        %>
        <div class="p-3 bg-black text-white text-sm">인기 게시판</div>
        <%
            }
        %>
    </div>
    <div class="my-5 flex items-center">
        <div class="flex-1 flex">
        <%
            for(int i=0; i<2; i++){
        %>
        <div class="p-3 bg-[#DC3545] text-white text-sm">모든글</div>
        <%
            }
        %>
        </div>
        <div class="text-sm">로그인</div>
    </div>
</body>
</html>
