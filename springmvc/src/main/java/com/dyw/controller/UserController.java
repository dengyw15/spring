package com.dyw.controller;

import com.dyw.exception.SysException;
import com.dyw.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"user"}) //添加到session域
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString执行了...");
        //模拟从数据库中查出user
        User user = new User();
        user.setName("zhangsan").setAge(20).setPassword("12345");
        model.addAttribute("user", user); //将对象添加到request域
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testString执行了...");
        //1、编写请求转发的程序,转发为一次请求，手工转发不会执行视图解析器，需要写转发后页面的路径
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        //2、重定向，为两次请求，重定向不能访问WEB-INF中的jsp页面
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        //3、直接返回相应
        //首先设置字符编码再返回
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("<h1>你好<h1>");
        return;
    }

    /**
     * ModelAndView 可以设置返回到页面的数据以及跳转的视图页面。视图解析器会根据ModelAndView中设置的
     * 视图名称，跳转到对应的页面
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testString执行了...");
        ModelAndView mv = new ModelAndView();
        //模拟从数据库中查出user
        User user = new User();
        user.setName("李四").setAge(30).setPassword("12345");

        mv.addObject("user", user);
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字实现请求的转发与重定向
     * @param
     * @return
     */
    @RequestMapping("/testForwardAndRedirect")
    public String testForwardAndRedirect(Model model) {
        System.out.println("testForwardAndRedirect执行了...");
        //模拟从数据库中查出user
        User user = new User();
        user.setName("wangwu").setAge(40).setPassword("12345");
        model.addAttribute("usr", user);
        //请求转发
//        return "forward:/WEB-INF/pages/success.jsp";

        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 异步请求和相应
     * @ResponseBody 注解返回json格式数据
     * @return
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax 执行了...");
        System.out.println(user);
        user.setAge(44);
        return user;
    }

    @RequestMapping("/testException")
    public String testException() throws Exception{
        System.out.println("testException 执行了...");

        try {
            //模拟异常
            int i = 10 / 0;
        } catch (Exception e) {
            //控制台打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("查询用户错误");
        }
        return "success";
    }

    /**
     * 测试拦截器
     * @return
     */
    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("testInterceptor 执行了...");
        return "success";
    }

}
