package com.employee.crudactivity.dao;

import com.employee.crudactivity.entity.emp;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class EmpDAOImpl implements EmpDAO{

    private EntityManager entityManager;

    public EmpDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    public List<emp> findAll(){
        Session currentSession =entityManager.unwrap(Session.class);
        Query<emp> theQuery =currentSession.createQuery("from emp",emp.class);
        List<emp> emp1=theQuery.getResultList();
        return emp1;
    }
    public emp findBySsn(int id){
        Session currentSession =entityManager.unwrap(Session.class);
        emp theemp=currentSession.get(emp.class,id);
        return theemp;
    }

    public void save(emp theemp){
        Session currentSession =entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theemp);

    }
    public void deleteBySsn(int theId){
        Session currentSession =entityManager.unwrap(Session.class);
        Query theQuery=currentSession.createQuery("delete from emp where ssn= :SsnId");
        theQuery.setParameter("SsnId",theId);
        theQuery.executeUpdate();
    }

}