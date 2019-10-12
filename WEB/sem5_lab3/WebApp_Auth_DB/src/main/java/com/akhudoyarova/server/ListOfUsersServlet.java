package com.akhudoyarova.server;

import com.akhudoyarova.dao.LoginPass_dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(name = "ListOfUsersServlet")
public class ListOfUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder listOfAll = new StringBuilder("users:\n");
        LoginPass_dao dao = new LoginPass_dao();
        HashSet<String> data = dao.getAll();

        for (String str: data) {
            listOfAll.append(str).append("\n");
        }
        request.setAttribute("list", listOfAll);
        request.getRequestDispatcher("registered_users.jsp").forward(request, response);
    }
}
