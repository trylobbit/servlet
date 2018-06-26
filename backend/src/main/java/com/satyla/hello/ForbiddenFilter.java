package com.satyla.hello;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class ForbiddenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        final String browserInfo = request1.getHeader("User-Agent");
        if(browserInfo.contains("Firefox") && LocalDateTime.now().getHour()<13) {
            response1.sendError(403, "Forbidden error");
        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
