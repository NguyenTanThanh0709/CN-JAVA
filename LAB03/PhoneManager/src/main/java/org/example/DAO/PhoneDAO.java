package org.example.DAO;

import org.example.IDAO.IDAO;
import org.example.POJO.Manufacture;
import org.example.POJO.Phone;

import java.util.List;
import org.example.Hibernate.HibernateUtils;
import org.example.IDAO.IDAO;
import org.example.POJO.Phone;
import org.hibernate.Criteria;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneDAO implements IDAO<Phone> {
    @Override
    public boolean add(Phone manufacture) {
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
    public Phone get(String id) {
        Phone manu = new Phone();
        Session session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();

        manu = session.get(Phone.class, id);

        session.getTransaction().commit();
        session.close();
        return  manu;
    }

    @Override
    public List<Phone> getAll() {
        List<Phone> lists = new ArrayList<Phone>();
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

            String hql = "delete from Phone where Id= :Id";
            session.createQuery(hql).setString("Id", id).executeUpdate();

            session.getTransaction().commit();
            session.close();
            return  true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean remove(Phone manufacture) {
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
    public boolean update(Phone manufacture) {
        try {
            Session session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Phone.class);
//            criteria.add(Restrictions.eq("Id", id));
            Phone manu = (Phone) criteria.uniqueResult();

//            employee.setName("John Doe");
//            employee.setSalary(50000.00);

            // set some thing
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            String country = sc.nextLine();
            String color = sc.nextLine();
            int price = sc.nextInt();
            int quantity = sc.nextInt();
            System.out.println("nhap id manufacture");
            String id = sc.nextLine();
            ManufactureDAO test = new ManufactureDAO();
            List<Manufacture> list = test.getAll();
            for (Manufacture item:
                 list) {
                if(id.equals(item.getId())){
                    manu.setManufacture(item);
                }

            }
            manu.setName(name);
            manu.setCountry(country);
            manu.setColor(color);
            manu.setPrice(price);
            manu.setQuanlity(quantity);



            session.update(manu);

            session.getTransaction().commit();
            session.close();
            return  true;

        }catch (Exception e){

        }
        return false;
    }
}
