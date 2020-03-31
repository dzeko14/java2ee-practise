package com.github.dzeko14.servlets;

import com.github.dzeko14.ejb.RecordEjb;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/records")
public class RecordsServlet extends HttpServlet {
    @EJB
    RecordEjb recordEjb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("records.jsp");
        String coachPhone = req.getParameter("coachPhone");
        req.setAttribute("coaches", recordEjb.getCoachRecordsFromToday(coachPhone));
        rd.forward(req, resp);
    }
}
