package com.github.dzeko14.servlets;

import com.github.dzeko14.ejb.TrainingEjb;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTraining")
public class RemoveTrainingServlet extends HttpServlet {
    @EJB
    TrainingEjb trainingEjb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int trainingId = Integer.parseInt(req.getParameter("id"));
        trainingEjb.removeTrainingById(trainingId);
        resp.sendRedirect("coaches");
    }
}
