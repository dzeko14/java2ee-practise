package com.github.dzeko14.servlets;

import com.github.dzeko14.constants.ParamsConstants;
import com.github.dzeko14.models.User;
import com.github.dzeko14.models.dao.UserDao;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    @EJB
    UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        User user = userDao.getUserByNumber(phone);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute(ParamsConstants.USER, user);
            resp.sendRedirect("test.html");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("auth.jsp");
            req.setAttribute("authError", true);
            rd.forward(req, resp);
        }
    }
}
