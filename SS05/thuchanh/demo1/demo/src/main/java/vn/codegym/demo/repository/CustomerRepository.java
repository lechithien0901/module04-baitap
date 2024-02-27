package vn.codegym.demo.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.codegym.demo.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    static EntityManager entityManager;
    static SessionFactory sessionFactory;
    @Override
    public List<Customer> findAll() {
        String query="select c from Customer c";
        TypedQuery<Customer> query1=entityManager.createQuery(query, Customer.class);


        return query1.getResultList() ;
    }

    @Override
    public Customer findOne(long id) {
        String query="select c from Customer c where c.id=:id";
        TypedQuery<Customer>query1=entityManager.createQuery(query, Customer.class);
        query1.setParameter("id",id);
        return query1.getSingleResult();
    }

    @Override
    public Customer save(Customer customer) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            Customer origin=findOne(customer.getId());
            origin.setId(customer.getId());
            origin.setName(customer.getName());
            origin.setProducer(customer.getProducer());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }finally {
            if (session != null) {
                session.close();
            }

        }
        return null;
    }
}
