package ru.akhudoyarova.lab;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@WebServlet("/SiteServlet")
public class SiteServlet extends javax.servlet.http.HttpServlet {
    HashMap<Integer, Set<String>> database;
    SessionSingletone sessionId;

    public void init() {
        database = new HashMap<Integer, Set<String>>();
        sessionId = SessionSingletone.getInstance(); //only one session id
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int answer = 0;
        answer = Integer.parseInt(request.getParameter("answer"));
        String hashString = request.getParameter("hash");
        if (database.containsKey(answer)) {
            if (database.get(answer).contains(hashString)) {
                String userId = UUID.randomUUID().toString();
                sessionId.addId(userId);
                Cookie cookie = new Cookie("sessionId", userId);
                response.addCookie(cookie);
                request.getRequestDispatcher("/hello_inside.jsp").forward(request, response);
            }
        }
        else {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Wrong answer. Try again');");
            out.println("location='SiteServlet';");
            out.println("</script>");
        }
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        int firstNum = -125 + (int) (Math.random() * 347);
        int secondNum = -125 + (int) (Math.random() * 347);
        int resultSum = firstNum + secondNum;

        String hashString = Integer.toString(Long.toString(resultSum + System.currentTimeMillis()).hashCode());

        if (database.containsKey(resultSum)) {
            database.get(resultSum).add(hashString);
        }
        else {
            Set<String> tmp = new HashSet<String>();
            tmp.add(hashString);
            database.put(resultSum, tmp);
        }

        request.setAttribute("number1", firstNum);
        request.setAttribute("number2", secondNum);
        request.setAttribute("hash", hashString);

        request.getRequestDispatcher("/count_to_get_in.jsp").forward(request, response);
    }
}