package com.akhudoyarova.server;

import com.akhudoyarova.dao.LoginPass_dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String inputpasswd = request.getParameter("password");

        PrintWriter out = response.getWriter();

        LoginPass_dao dao_logPass = new LoginPass_dao();
        boolean existance = dao_logPass.checkExistance(username);
        if (existance) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('User already exists! Choose another login and try again');");
            out.println("location='sign_up';");
            out.println("</script>");
        }
        else {
            dao_logPass.addLoginPasswd(username, inputpasswd);
            response.sendRedirect("index.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign_up_page.jsp").forward(request, response);
    }
}
