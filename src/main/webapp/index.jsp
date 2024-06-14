<%@ page import="com.jsp.jsp_board.DTO.TestDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="assets/js/script.js"></script>
    <script>

    </script>
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<a href="hello-servlet">Hello Servlet</a>
<a href="boardRead-servlet2">boardRead Servlet</a>
<%--<form action="signup" method="post">--%>
<%--    <label for="name">Name:</label>--%>
<%--    <input type="text" id="name" name="name">--%>
<%--    <br><br>--%>
<%--    <input type="submit" value="Submit">--%>
<%--    <img src="assets/images/google_logo.png" />--%>

<%--    <div class="text">--%>
<%--        Hello world!!!!--%>
<%--    </div>--%>
<%--    <div class="container">text</div>--%>
<%--    <div class="border text-3xl">test</div>--%>
<%--    <input type="submit" value="제출" />--%>
<%--</form>--%>

<jsp:include page="component/header/index.jsp" />
<jsp:include page="component/main/index.jsp" />

<h1>API 조회 결과</h1>
<button id="loadData">Load Data</button>
<ul id="dataList"></ul>

<h1>API에서 가져온 데이터</h1>
<div>
    <%= request.getAttribute("jsonData") %>
</div>

</body>
</html>