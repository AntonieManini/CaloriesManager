package com.anton.project.repository.jpa;

import com.anton.project.model.User;
import com.anton.project.model.UserMeal;
import com.anton.project.repository.UserMealRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * Created by Anton on 18.02.16.
 */

@Repository
@Transactional(readOnly = true)
public class JpaUserMealRepository implements UserMealRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        User user = em.getReference(User.class, userId);
        userMeal.setUser(user);

        if (userMeal.isNew()) {
            em.persist(userMeal);

            return userMeal;
        }
        else {
            return get(userMeal.getId(), userId) == null ? null : em.merge(userMeal);
        }
    }

    @Transactional
    @Override
    public boolean delete(int id, int userId) {
        return em.createNamedQuery(UserMeal.DELETE)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .executeUpdate() != 0;
    }

    @Override
    public UserMeal get(int id, int userId) {
        List<UserMeal> meals = em.createNamedQuery(UserMeal.GET, UserMeal.class)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .getResultList();

        return DataAccessUtils.singleResult(meals); //returns null if empty
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return em.createNamedQuery(UserMeal.ALL_SORTED, UserMeal.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return em.createNamedQuery(UserMeal.GET_BETWEEN, UserMeal.class)
                .setParameter("userId", userId)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }
}
