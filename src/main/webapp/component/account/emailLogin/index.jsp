<%--
  Created by IntelliJ IDEA.
  User: ZPOG9-002
  Date: 2024-06-20
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script></script>
</head>
<body>
    <jsp:include page="../../header/index.jsp" />
    <jsp:include page="../../main/search/index.jsp" />

    <div class="flex items-center flex-col">
        <div class="flex my-12">
            <img src="/assets/images/email.svg" />
            <div class="ml-5 flex items-center justify-center border rounded-lg px-5 shadow-sm">
                <div class="text-sm">로그인 해주세요. 제발</div>
            </div>
        </div>
        <form method="post" action="/emailLogin">
            <div class="text-xs mb-2">아이디</div>
            <input name="id" class="border mb-4 w-[300px] rounded px-3 py-1" />
            <div class="text-xs mb-2">비밀번호</div>
            <input type="password" name="password" class="border mb-4 w-[300px] rounded px-3 py-1" />
            <input value="로그인" type="submit" class="text-xs w-[300px] h-9 flex items-center rounded justify-center bg-blue-300 text-white cursor-pointer" />

            <%
                String error = (String) request.getAttribute("loginError");
                System.out.println("login error: " + error);
                if("id".equals(error)){
            %>
            <div class="text-bold mt-4 text-xs text-red-600">아이디가 틀렸습니다.</div>
            <%
                }else if("password".equals(error)){
            %>
            <div class="text-bold mt-4 text-xs text-red-600">비밀번호가 틀렸습니다.</div>
            <%
                }
            %>
        </form>
    </div>
</body>
</html>
