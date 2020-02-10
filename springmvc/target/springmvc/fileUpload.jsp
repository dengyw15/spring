<%--
  Created by IntelliJ IDEA.
  User: DYW
  Date: 2020/2/7
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<!--
文件上传
必要前提： form表单的enctype(表单请求正文的类型)取值必须是：multipart/form-data（默认是application/x-www-form-urlencoded）
method 属性取值必须是post
提供一个文件选择域 <input type="file/>
借助第三方组件实现文件上传commons-fileupload
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery.min.js"></script>
</head>
<body>
    <h3>传统方式上传</h3>
    <form action="/file/fileUpload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        姓名：<input type="text" name="name"/>
        年龄：<input type="text" name="age"/>
        <input type="submit" value="upload"/>
    </form>

    <h3>SpringMVC方式上传</h3>
    <form action="/file/fileUpload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload" multiple="true"/><br/>
        姓名：<input type="text" name="name"/>
        年龄：<input type="text" name="age"/>
        <input type="submit" value="upload"/>
    </form>

    <h3>跨服务器文件上传</h3>
    <form action="/file/fileUpload3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload" multiple="true"/><br/>
        姓名：<input type="text" name="name"/>
        年龄：<input type="text" name="age"/>
        <input type="submit" value="upload"/>
    </form>
</body>
</html>
