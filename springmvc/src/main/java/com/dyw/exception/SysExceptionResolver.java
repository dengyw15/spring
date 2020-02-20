package com.dyw.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器  需要实现HandlerExceptionResolver
 */
public class SysExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理异常的业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e 当前抛出的异常对象
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException ex  = null;
        if (e instanceof SysException) {
            ex = (SysException) e;
        } else {
            ex = new SysException("系统正在维护中...");
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", ex.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
