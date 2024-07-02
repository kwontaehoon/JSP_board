<%@ page import="com.jsp.jsp_board.DTO.TestDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ZPOG9-002
  Date: 2024-06-10
  Time: 오전 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="/component/main/search/index.jsp" />
    <div class="md:px-40 px-20 py-12">
        <jsp:include page="/component/main/filter/index.jsp" />
        <jsp:include page="/component/main/board/index.jsp" />
    </div>
</body>
</html>
