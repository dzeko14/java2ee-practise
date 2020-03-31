package com.github.dzeko14.ejb;

import com.github.dzeko14.models.Record;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class RecordEjb {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Record> getCoachRecordsFromToday(String coachPhone) {
        long dateNow = new Date().getTime();
        return entityManager
                .createQuery("select r from Record r where r.coach.phoneNumber = :coachPhone and r.date >= :dateNow ")
                .setParameter("coachPhone", coachPhone)
                .setParameter("dateNow", dateNow)
                .getResultList();
    }
}
