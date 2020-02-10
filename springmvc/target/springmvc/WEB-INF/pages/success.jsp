<%--
  Created by IntelliJ IDEA.
  User: DYW
  Date: 2020/2/5
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h1>成功</h1>
    ${requestScope.user}
    ${sessionScope.user}
    ${user}
    <%
        System.out.println("sucess.jsp 执行了...");
    %>
</body>
</html>
