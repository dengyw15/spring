<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="account/findAll">获取所有</a>

<form action="account/saveAccount" method="post">
    姓名：<input type="text" name="name"/><br>
    金额：<input type="text" name="money"/><<br>
    <input type="submit" value="SAVE"/><br>
</form>
</body>
</html>
