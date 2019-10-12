package com.akhudoyarova.server;

import com.akhudoyarova.dao.LoginHash_dao;
import com.akhudoyarova.dao.LoginPass_dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "SignInServlet")
public class SignInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String inputpasswd = request.getParameter("password");

        LoginPass_dao dao_logPass = new LoginPass_dao();
        boolean existance = dao_logPass.existLoginPass(username, inputpasswd);
        if (existance) {
            String uuid = UUID.randomUUID().toString();
            LoginHash_dao dao_loginHash = new LoginHash_dao();
            boolean added = dao_loginHash.addLoginHash(username,uuid);
            if (added) {
                Cookie cookie = new Cookie("sessionId", uuid);
                response.addCookie(cookie);
            }
            response.sendRedirect("registered");
        }
        else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Unvalid login or password. ');");
            out.println("location='sign_in';");
            out.println("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign_in_page.jsp").forward(request, response);
    }
}
