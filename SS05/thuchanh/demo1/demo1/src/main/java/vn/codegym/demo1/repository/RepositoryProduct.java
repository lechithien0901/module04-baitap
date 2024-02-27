package vn.codegym.demo1.repository;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.demo1.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Queue;

import org.hibernate.SessionFactory;

@Repository
public class RepositoryProduct implements IRepositoryProduct {

    static {
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            sessionFactory.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @PersistenceContext
    public EntityManager entityManager;

    public  SessionFactory sessionFactory;

     {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> showList() {
        String queryStr = "select p from Product as p ";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        entityManager.persist(product);

    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
           Product origin = getProduct(product.getId());
            origin.setName(product.getName());
            origin.setSalary(product.getSalary());
            origin.setPDescribe(product.getPDescribe());
            origin.setProducer(product.getProducer());

            session.saveOrUpdate(origin);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }


    }

    @Override
    @Transactional
    public void deleteProduct(long id) {
        Product product=getProduct(id);
      entityManager.remove(product);

    }

    @Override
    public Product getProduct(long id) {
        String queryStr = "select p from Product p where p.id=:id";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
