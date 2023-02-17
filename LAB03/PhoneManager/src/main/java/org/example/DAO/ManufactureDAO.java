package org.example.DAO;

import org.example.Hibernate.HibernateUtils;
import org.example.IDAO.IDAO;
import org.example.POJO.Manufacture;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManufactureDAO implements IDAO<Manufacture> {
    @Override
    public boolean add(Manufacture manufacture) {
        try {
            Session session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();

            session.save(manufacture);

            session.getTransaction().commit();
            session.close();
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public Manufacture get(String id) {
        Manufacture manu = new Manufacture();
        Session session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();

        manu = session.get(Manufacture.class, id);

        session.getTransaction().commit();
        session.close();
        return  manu;
    }

    @Override
    public List<Manufacture> getAll() {
        List<Manufacture> lists = new ArrayList<Manufacture>();
        Session session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("FROM Manufacture");
        lists = q.getResultList();

        session.getTransaction().commit();
        session.close();
        return  lists;
    }

    @Override
    public boolean remove(String id) {
        try {
            Session session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();

            String hql = "delete from Manufacture where Id= :Id";
            session.createQuery(hql).setString("Id", id).executeUpdate();

            session.getTransaction().commit();
            session.close();
            return  true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean remove(Manufacture manufacture) {
        try {
            Session session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();

            session.delete(manufacture);

            session.getTransaction().commit();
            session.close();
            return  true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean update(Manufacture manufacture) {

        try {
            Session session = HibernateUtils.getFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            session.beginTransaction();

            CriteriaUpdate<Manufacture> criteriaUpdate = cb.createCriteriaUpdate(Manufacture.class);
            Root<Manufacture> root = criteriaUpdate.from(Manufacture.class);
            criteriaUpdate.set("Name", "newPrice");
            criteriaUpdate.where(cb.equal(root.get("Id"), "125"));

//            Transaction transaction = session.beginTransaction();
            session.createQuery(criteriaUpdate).executeUpdate();
//            transaction.commit();

//            Criteria criteria = session.createCriteria(Manufacture.class);
//            criteria.add(Restrictions.eq("Id", manufacture.getId()));
//            Manufacture manu = (Manufacture) criteria.uniqueResult();

//            employee.setName("John Doe");
//            employee.setSalary(50000.00);

//            Scanner sc = new Scanner(System.in);
//            String name = sc.nextLine();
//            String Location = sc.nextLine();
//            sc.nextLine();
//            int E = sc.nextInt();
//
////            // set some thing
//            manu.setName(name);
//            manu.setLocation(Location);
//            manu.setEmployee(E);
//
//            session.update(manu);

            session.getTransaction().commit();
            session.close();
            return  true;

        }catch (Exception e){

        }
        return false;
    }
}
