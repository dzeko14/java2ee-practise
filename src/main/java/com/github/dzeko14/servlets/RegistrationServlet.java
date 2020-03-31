package com.github.dzeko14.servlets;

import com.github.dzeko14.models.User;
import com.github.dzeko14.models.dao.UserDao;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    @EJB
    UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        User user = new User(phone, name, password);

        if (!userDao.saveUser(user)) {
            RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
            req.setAttribute("regError", true);
            rd.forward(req, resp);
        } else {
            resp.sendRedirect("auth.jsp");
        }
    }
}
