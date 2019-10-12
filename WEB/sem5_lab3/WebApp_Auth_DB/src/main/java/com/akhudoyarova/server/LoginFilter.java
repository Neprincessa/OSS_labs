package com.akhudoyarova.server;

import com.akhudoyarova.dao.LoginHash_dao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Cookie[] cookies = request.getCookies();
        if (cookies != null ) {
            for ( Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    String sessionId = cookie.getValue();
                    LoginHash_dao loginHash_dao = new LoginHash_dao();
                    if (request.getMethod().equalsIgnoreCase("GET")) {
                        boolean registered = loginHash_dao.existHashTable(sessionId);
                        if (registered) {
                            request.getRequestDispatcher("registered").forward(request, response);
                        }
                    }
                    else {
                        String username = (String) request.getParameter("username");
                        boolean valid = loginHash_dao.existLoginHash(username, sessionId);
                        if (valid) {
                            request.getRequestDispatcher("registered").forward(request, response);
                        }
                    }
                }
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
