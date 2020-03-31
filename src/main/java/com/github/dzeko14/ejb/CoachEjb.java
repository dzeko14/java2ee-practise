package com.github.dzeko14.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CoachEjb {
    @PersistenceContext
    private EntityManager entityManager;

    public List<CoachEjb> getAllCoaches() {
        return entityManager.createQuery("SELECT c from Coach c").getResultList();
    }
}
