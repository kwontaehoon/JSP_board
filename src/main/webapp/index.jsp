<%@ page import="com.jsp.jsp_board.DTO.BoardDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

    <script src="https://cdn.tailwindcss.com"></script>

<%--    script 태그는 닫는 태그가 꼭 필요--%>
    <script src="/assets/js/testFunc.js"></script>


    <script>

        console.log(123);

        window.onload = function() {
            const result = testFunc(); // testFunc 함수를 호출
            const resultDiv = document.getElementById('result');
            resultDiv.textContent = result; // 결과를 div에 출력
        };

        function test() {
            alert('테스트 버튼 클릭');
        }
    </script>



    <%!  String a = "JSP 변수 테스트";   %>

</head>
<body>
    <div class="m-2"><a href="/main">게시판 들어가기</a></div>
    <div class="m-2"><a href="/t">test</a></div>
    <div class="m-2"><a href="/hello-servlet">aaa</a></div>
    <div class="m-2"><a href="/component/account/emailLogin/index.jsp">로그인</a></div>
    <div class="m-2"><input type="button" onclick="test();" value="테스트"/></div>
    <div class="m-2" id="result"></div>
    <div class="m-2"><%=a %></div>
    <div class="m-2"><a href="/" class="text-blue border">들어가기</a></div>
</body>
</html>
