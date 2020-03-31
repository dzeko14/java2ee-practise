package com.github.dzeko14.servlets;

import com.github.dzeko14.ejb.CoachEjb;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/coaches")
public class CoachesServlet extends HttpServlet {
    @EJB
    CoachEjb coachEjb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("coaches.jsp");
        req.setAttribute("coaches", coachEjb.getAllCoaches());
        rd.forward(req, resp);
    }
}
