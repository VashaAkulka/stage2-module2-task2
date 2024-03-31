package com.example.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        RequestDispatcher dispatcher;

        if (session != null && session.getAttribute("user") != null) {
            dispatcher = req.getRequestDispatcher("login.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("user/hello.jsp");
        }
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession(false);
        RequestDispatcher dispatcher;

        if (!login.isEmpty() && !password.isEmpty()) {
            session.setAttribute("user", "/user/hello");
            dispatcher = req.getRequestDispatcher("/user/hello.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("login.jsp");
        }

        dispatcher.forward(req, resp);
    }
}
