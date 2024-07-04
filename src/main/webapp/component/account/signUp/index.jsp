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
</head>
<body>
<jsp:include page="../../header/index.jsp" />
<jsp:include page="../../main/search/index.jsp" />

<div class="flex items-center flex-col">
    <div class="flex my-12">
        <img src="/assets/images/email.svg" />
        <div class="ml-5 flex items-center justify-center border rounded-lg px-5 shadow-sm">
            <div class="text-sm">회원가입 정보르 입력해주세요.</div>
        </div>
    </div>
    <form method="post" action="/signUp">
        <div class="text-xs mb-2">아이디</div>
        <input name="id" class="border mb-4 w-[300px] rounded px-3 py-1" />
        <div class="text-xs mb-2">비밀번호</div>
        <input name="password" class="border mb-4 w-[300px] rounded px-3 py-1" />
        <div class="text-xs mb-2">비밀번호 확인</div>
        <input class="border mb-4 w-[300px] rounded px-3 py-1" />
        <div class="text-xs mb-2">이름</div>
        <input class="border mb-4 w-[300px] rounded px-3 py-1" />
        <div class="text-xs mb-2">닉네임</div>
        <input class="border mb-4 w-[300px] rounded px-3 py-1" />
        <div class="text-xs mb-2">이메일</div>
        <input class="border mb-8 w-[300px] rounded px-3 py-1" />
        <div class="text-xs mb-2">생년월일</div>
        <input class="border mb-4 w-[300px] rounded px-3 py-1" />
        <input value="회원가입" type="submit" class="text-xs w-[300px] h-9 flex items-center rounded justify-center bg-blue-300 text-white cursor-pointer" />
    </form>
</div>
</body>
</html>
