package ru.akhudoyarova.lab;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SiteFilter implements javax.servlet.Filter {
    private SessionSingletone sessionId;


    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Boolean param = true;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie tmp: cookies) {
                if (tmp.getName().equals("sessionId")) {
                    if (sessionId.checkId(tmp.getValue())) {
                        request.getRequestDispatcher("/hello_inside.jsp").forward(request, response);
                        param = false;
                    }
                }
            }
        }
        if(param)
        {
            request.getRequestDispatcher("SiteServlet").forward(request, response);
        }

        chain.doFilter(request, response);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
        sessionId = SessionSingletone.getInstance();
    }

}