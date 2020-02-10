package com.dyw.interceptor;

import com.dyw.exception.SysException;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor2 implements HandlerInterceptor {

    /**
     * 预处理，controller执行之前执行
     * @param request
     * @param response
     * @param handler
     * @return true,放行，执行下一个拦截器，如果没有则执行controller中的方法； false 不放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1 执行了...前222");
        String name = request.getParameter("name");
        if (StringUtils.isEmpty(name)) {
            throw new SysException("请输入姓名");
        } else {
            return true;
        }
    }

    /**
     * 后处理方法。controller中的方法执行后 跳转controller指定页面之前，执行该方法。
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1 执行了...后222");
    }

    /**
     * 最后执行方法。 跳转页面执行只有，执行该方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("MyInterceptor1 执行了...最后222");
    }
}
