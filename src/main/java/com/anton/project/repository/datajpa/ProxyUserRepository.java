package com.anton.project.repository.datajpa;

import com.anton.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 22.02.16.
 */
@Transactional(readOnly = true)
public interface ProxyUserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Override
    User save(User user);

    @Override
    List<User> findAll();

    @Override
    User findOne(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    User getByEmail(String email);
}
