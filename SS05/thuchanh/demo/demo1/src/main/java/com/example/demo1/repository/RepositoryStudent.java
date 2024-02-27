package com.example.demo1.repository;

import com.example.demo1.model.Student;
import com.mysql.cj.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class RepositoryStudent implements IRepositoryStudent {

    private static SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        String sql = "select s from Student s";
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery(sql, Student.class);
        return studentTypedQuery.getResultList();
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);


    }

    @Override
    public List<Student> findByName(String keyword) {
        return null;
    }
}
