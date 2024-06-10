<%@ page import="com.jsp.jsp_board.DTO.TestDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<a href="hello-servlet">Hello Servlet</a>
<a href="boardRead-servlet">boardRead Servlet</a>
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
<ul>
    <%
        List<TestDTO> dataList = (List<TestDTO>) request.getAttribute("dataList");
        if(dataList != null) {
            for(TestDTO data : dataList) {
    %>
    <li><%= data.getValue() %></li> <!-- 여기서 getValue()는 데이터에서 실제 값을 가져오는 메서드입니다. -->
    <%
            }
        }
    %>
</ul>

</body>
</html>