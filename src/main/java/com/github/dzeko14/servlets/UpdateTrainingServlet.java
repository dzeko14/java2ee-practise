package com.github.dzeko14.servlets;

import com.github.dzeko14.ejb.TrainingEjb;
import com.github.dzeko14.models.Training;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateTraining")
public class UpdateTrainingServlet extends HttpServlet {
    @EJB
    TrainingEjb trainingEjb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int trainingId = Integer.parseInt(req.getParameter("id"));
        RequestDispatcher rd = req.getRequestDispatcher("updateTraining.jsp");
        Training training = trainingEjb.getUserTrainingById(trainingId);
        req.setAttribute("training", training);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int trainingId = Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        trainingEjb.updateTrainingQuantity(quantity, trainingId);
        resp.sendRedirect("coaches");
    }
}