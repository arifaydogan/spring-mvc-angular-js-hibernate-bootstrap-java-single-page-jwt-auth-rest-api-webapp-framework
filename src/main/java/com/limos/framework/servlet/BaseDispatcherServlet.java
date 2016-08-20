package com.limos.framework.servlet;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: arifaydogan
 * @date: 01/08/2016
 */
public class BaseDispatcherServlet extends DispatcherServlet {

    private static final long serialVersionUID = 112233448L;


    @Override
    protected void doService(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        super.doService(request, response);
    }


    @Override
    protected void doDispatch(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        super.doDispatch(request, response);
    }


    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        super.service(request, response);
    }

}
