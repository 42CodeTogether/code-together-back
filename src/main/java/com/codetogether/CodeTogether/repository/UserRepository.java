package com.codetogether.CodeTogether.repository;

import com.codetogether.CodeTogether.domain.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class UserRepository {
    private final EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public User save(User user) {
        em.persist(user);
        return user;
    }

    public Optional<User> findByIntraId(String intraId) {
        User user = em.find(User.class, intraId);
        return Optional.ofNullable(user);
    }

    public Optional<User> findByTeam(int team) {
        List<User> result = em.createQuery("select u from u where u.team = :id", User.class)
                .setParameter("id", team)
                .getResultList();
        return result.stream().findAny();
    }

    public Optional<User> findByProject(String project) {
        List<User> result = em.createQuery("select u from u where u.project = :project", User.class)
                .setParameter("project", project)
                .getResultList();
        return result.stream().findAny();
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }
}
