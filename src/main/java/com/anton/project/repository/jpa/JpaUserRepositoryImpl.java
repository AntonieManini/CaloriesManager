package com.anton.project.repository.jpa;

import com.anton.project.model.User;
import com.anton.project.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Anton on 18.02.16.
 */

@Repository
@Transactional(readOnly = true) //reduces overhead of transaction when fetching objects
public class JpaUserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);

            return user;
        }
        else {
            return em.merge(user);
        }
    }

    @Override
    public boolean delete(int id) {
        //gets a proxy object, not a real user
/*        User ref = em.getReference(User.class, id);
        em.remove(ref);*/

        return em.createNamedQuery(User.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User getByEmail(String email) {
        return em.createNamedQuery(User.BY_EMAIL, User.class).setParameter(1, email).getSingleResult();
    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
    }
}
