package com.github.dzeko14.ejb;

import com.github.dzeko14.models.Coach;
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

    public Training getUserTrainingById(int id) {
        return entityManager.find(Training.class, id);
    }

    public void createTraining(String coachPhone, String userPhone, int quantity) {
        Coach coach = entityManager.find(Coach.class, coachPhone);
        Training training = new Training();
        training.setUserPhone(userPhone);
        training.setCoach(coach);
        training.setAmount(quantity);
        entityManager.persist(training);
    }

    public void removeTrainingById(int trainingId) {
        entityManager.remove(entityManager.find(Training.class, trainingId));
    }

    public void updateTrainingQuantity(int quantity, int trainingId) {
        entityManager.find(Training.class, trainingId).setAmount(quantity);
    }
}
