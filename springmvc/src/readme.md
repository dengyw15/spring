# 拦截器Interceptor与过滤器Filter
##　区别：
* 过滤器是servlet规范中的一部分，任何javaweb工程都可以用
  拦截器是SpringMVC框架自己的，只有使用了SpringMVC框架的工程才能用
* 过滤器在url-pattern中配置了/*之后，可以对所有要访问的资源进行拦截
   拦截器只会拦截访问的控制器方法，如果访问的是jsp，html，CSS，image或者js是不会进行拦截的

拦截器是AOP思想的具体应用

过滤器>拦截器

要自定义拦截器，需要实现 HandlerInterceptor接口

## 创建步骤
1、编写拦截器
实现HandlerInterceptor接口
2、配置拦截器
```xml
<mvc:interceptors>
        <mvc:interceptor>
            <!--要拦截的方法-->
            <mvc:mapping path="/user/*"/>
            <!--不要拦截的方法-->
            <!--<mvc:exclude-mapping path=""></mvc:exclude-mapping>-->
            <!--配置拦截器对象-->
            <bean class="com.dyw.interceptor.MyInterceptor1"></bean>
        </mvc:interceptor>

        <!--配置第二个拦截器-->
        <mvc:interceptor>
            <!--要拦截的方法-->
            <mvc:mapping path="/**"/>
            <!--不要拦截的方法-->
            <!--<mvc:exclude-mapping path=""></mvc:exclude-mapping>-->
            <!--配置拦截器对象-->
            <bean class="com.dyw.interceptor.MyInterceptor2"></bean>
        </mvc:interceptor>
    </mvc:interceptors>
```