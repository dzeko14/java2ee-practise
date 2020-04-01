package com.github.dzeko14.ejb;

import com.github.dzeko14.models.Training;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class TrainingEjb {
    @PersistenceContext
    private EntityManager entityManager;

    public Training getUserTrainingByCoach(String coachPhone, String userPhone) {
        Training result;
        try {
            result = (Training) entityManager
                    .createQuery("select r from Training r where r.coach.phoneNumber = :coachPhone and r.userPhone >= :userPhone")
                    .setParameter("coachPhone", coachPhone)
                    .setParameter("userPhone", userPhone)
                    .getSingleResult();
        } catch (NoResultException e) {
            result = null;
        }
        return result;
    }
}
