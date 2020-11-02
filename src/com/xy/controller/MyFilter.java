package com.xy.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServlet req = (HttpServlet) servletRequest;
        HttpServlet resp = (HttpServlet) servletResponse;
    }

    @Override
    public void destroy() {

    }
}
