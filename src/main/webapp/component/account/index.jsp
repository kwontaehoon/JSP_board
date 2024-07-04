<%--
  Created by IntelliJ IDEA.
  User: ZPOG9-002
  Date: 2024-06-20
  Time: 오후 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="assets/js/script.js"></script>
    <link rel="stylesheet" href="assets/css/styles.css">

    <title>Title</title>
</head>
<body>
    <jsp:include page="../header/index.jsp" />
    <jsp:include page="../main/search/index.jsp" />
    <div class="flex border h-full items-center flex-col">
        <img src="/assets/images/login_logo.png" class="w-[300px] h-[300px]" />
        <div class="flex flex-col text-black-300 text-white ">
            <div class="my-2 w-[380px] border p-3 rounded flex justify-center bg-red-200">구글 로그인</div>
            <div class="my-2 w-[380px] border p-3 rounded flex justify-center bg-green-200">카카오 로그인</div>
            <a href="/component/account/emailLogin/index.jsp" class="my-2 w-[380px] border p-3 rounded flex bg-blue-200 justify-center">이메일 로그인</a>
            <a href="/component/account/signUp/index.jsp" class="text-black flex justify-end text-xs">회원가입</a>
        </div>
    </div>
</body>
</html>
