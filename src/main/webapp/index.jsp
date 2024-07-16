<%@ page import="com.jsp.jsp_board.DTO.BoardDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jsp.jsp_board.utill.Test" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP</title>

    <style>
        .box1 { background-color: #3498db; }
        .box2 { background-color: #e74c3c; }

        .active { background-color: aqua; }
        .test1 { background-color: #ee2; }
        .test2 { background-color: #e74c3c; }
        .test3 { background-color: #e3c5; }

    </style>

    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<%-- script 태그는 닫는 태그가 꼭 필요 --%>
    <script src="/assets/js/testFunc.js"></script>

    <script>

        window.onload = function() {
            const result = testFunc(); // testFunc 함수를 호출
            const resultDiv = document.getElementById('result');
            resultDiv.textContent = result; // 결과를 div에 출력
        };

        function test() {
            alert('테스트 버튼 클릭');
        }

        function toggleColor2(id) {
            $('#' + id).toggleClass('test1 test2 test3');
        }

        $(document).ready(function() {
            $('.custom-box').click(function() {
                // 모든 박스의 비활성화된 클래스 추가
                $('.custom-box').addClass('custom-box-inactive').removeClass('active');

                // 클릭된 박스에만 활성화된 클래스 추가
                $(this).addClass('active').removeClass('custom-box-inactive');
            });
        });

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
    <form method="post" action="/boardWrite">
        <input value="글쓰기 테스트" type="submit" />
    </form>

    <%
        String error = Test.main("ttttt");
    %>
    <div><%= error%> ============</div>

    <%
        String initialBoxClass = "test1";
    %>

    <%
        for(int i=0; i<3; i++){
    %>
        <div id="test<%= i %>" class="w-12 h-12 border rounded-full border-red <%=initialBoxClass %>" onclick="toggleColor2('test<%= i %>')"></div>
    <%
        }
    %>




    <%
        for(int i=0; i<3; i++){
    %>
        <div id="box<%= i %>" class="custom-box" onclick="toggleColor2('box<%= i %>')">Box <%= i %></div>
    <%
        }
    %>


</body>
</html>
