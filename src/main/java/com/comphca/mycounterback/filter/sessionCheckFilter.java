package com.comphca.mycounterback.filter;


import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @Created by comphca
 * @Date 2021/10/17 14:32
 * @Description TODO
 */
@Component
public class sessionCheckFilter implements Filter {

/*    @Autowired
    private UserService userService;*/

    /*白名单*/
    private Set<String> whiteRootPaths =  Sets.newHashSet(
            "login","msgsocks","test","order",""
    );

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //* 允许任何ajax调用处理当前服务返回的数据
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");

        /*HttpServletRequest request = (HttpServletRequest) servletRequest;
        //http://localhost:8080/login/pwdsetting
        //   /login/pwdsetting
        String path = request.getRequestURI();
        String[] split = path.split("/");
        if (split.length < 2){
            request.getRequestDispatcher("/login/loginfail").forward(servletRequest,servletResponse);
        }else {
            if (!whiteRootPaths.contains(split[0])){
                //不在白名单 验证token,前面登录之后放入到缓存的登录对象有效了
                if (userService.accountExistInCache(request.getParameter("token"))){
                    filterChain.doFilter(servletRequest,servletResponse);
                }else {
                    request.getRequestDispatcher("/login/loginfail").forward(servletRequest,servletResponse);
                }
            }else {
                {
                    //白名单 放行
                    filterChain.doFilter(servletRequest,servletResponse);
                }
            }

        }*/

        //doFilter  放行请求 让接下来的模块接着处理这个请求
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
