package com.github.dzeko14.servlets;

import com.github.dzeko14.constants.ParamsConstants;
import com.github.dzeko14.ejb.TrainingEjb;
import com.github.dzeko14.models.Training;
import com.github.dzeko14.models.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/training")
public class TrainingServlet extends HttpServlet {
    @EJB
    TrainingEjb trainingEjb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;
        String coachPhone = req.getParameter("coachPhone");
        String userPhone = ((User)req.getSession().getAttribute(ParamsConstants.USER)).getPhoneNumber();

        Training training = trainingEjb.getUserTrainingByCoach(coachPhone, userPhone);

        if (training != null) {
            rd = req.getRequestDispatcher("training.jsp");
            req.setAttribute("training", training);
        } else {
            rd = req.getRequestDispatcher("orderTraining.jsp");
            req.setAttribute("coachPhone", coachPhone);
        }

        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String coachPhone = req.getParameter("coachPhone");
        String quantity = req.getParameter("quantity");
        String userPhone = ((User)req.getSession().getAttribute(ParamsConstants.USER)).getPhoneNumber();

        trainingEjb.createTraining(coachPhone, userPhone, Integer.parseInt(quantity));
        resp.sendRedirect("coaches");
    }
}
