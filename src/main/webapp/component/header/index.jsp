<%--
  Created by IntelliJ IDEA.
  User: ZPOG9-002
  Date: 2024-06-10
  Time: 오전 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="px-8 bg-[#363944] text-white items-center flex">
        <div class="mr-8">
            <div class="whitespace-nowrap py-2">DAK.GG 전적검색</div>
        </div>
        <div class="flex justify-around whitespace-nowrap overflow-x-scroll">
            <%
                for(int i=0; i<10; i++){
            %>
            <div class="mx-5">e스포츠 일정</div>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>
