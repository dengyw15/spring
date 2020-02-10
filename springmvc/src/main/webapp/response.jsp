<%--
  Created by IntelliJ IDEA.
  User: DYW
  Date: 2020/2/5
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入jQuery资源文件时也是一次请求，当前在web.xml中配置的<url-pattern>/</url-pattern>，所有
    资源都会被dispatcherServlet拦截，因此需要在springmvc.xml里面配置不拦截哪些静态资源-->
    <script src="js/jquery.min.js"></script>

    <script>
        //页面加载，绑定单击事件
        $(function() {
            $("#btn").click(function () {
                // alert("hello btn")
                //发送ajax请求
                $.ajax({
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"name": "张三", "age": 23, "password": "123456"}',
                    dataType: "json",   //返回数据格式
                    type: "post",
                    success: function (resp) {
                        //resp是服务器端返回的json串
                        alert(resp);
                        alert(resp.name + ' ' + resp.age + ' ' + resp.password)
                    }
                });
            })
        })
    </script>
</head>
<body>
    返回字符串：<a href="user/testString">testString</a>
    <br/>
    返回void：<a href="user/testVoid">testVoid</a>
    <br/>
    ModelAndView的使用：<a href="user/testModelAndView">testModelAndView</a>
    <br>
    使用关键字完成请求转发及重定向：<a href="user/testForwardAndRedirect">testForwardAndRedirect</a>
    <br>
    <button id="btn">发送ajax请求</button>

    <br>

</body>
</html>
