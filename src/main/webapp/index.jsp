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
</body>
</html>