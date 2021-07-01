package com.holun.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringMVC中的拦截器类的作用类似于filter（过滤器）
 * SpringMVC框架提供的拦截器只会拦截访问的控制器方法，如果访问的是jsp/html/css/image/js是不会进行拦截的
 * 拦截器是SpringMVC框架提供的，只有使用了SpringMVC框架的工程才能使用拦截器
 * 拦截器本质是AOP思想的具体应用。
 */

public class LoginCheckInterceptor implements HandlerInterceptor {

    //preHandle方法会在请求处理器方法之前执行,该方法返回true就将拦截的请求放行,返回false，不会将拦截请求放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //用户登录的请求直接放行
        if (request.getRequestURI().contains("/loginCheck"))
            return true;

        //对处于已登录状态的请求直接放行
        if (request.getSession().getAttribute("uname") != null)
            return true;

        response.sendRedirect("/ssmbuild/login.jsp");

        //对处于未登录状态的请求将其拦截,即未登录就跳转到login.jsp页面
        return false;
    }
}
