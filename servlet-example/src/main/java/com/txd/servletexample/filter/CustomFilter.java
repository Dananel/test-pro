package com.txd.servletexample.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("web容器启动时初始化一次");
	}

	@Override
	public void destroy() {
		System.out.println("web容器关闭时，执行");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        System.out.println("在放开请求之前执行一段代码");
        // 只有执行了FilterChain.doFilter(request, response);才有可能执行到servlet业务代码
        chain.doFilter(request, response);
        // 响应到调用端之前，执行一段代码
        System.out.println("响应到调用端之前，执行一段代码");
	}
}
