package org.example.Handle;

import org.example.DAO.IStudent;
import org.example.Hibernate.HibernateUtils;
import org.example.pojo.Student;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO implements IStudent<Student> {

    public  static StudentDAO getInstance(){
        return  new StudentDAO();
    }

    @Override
    public int insert(Student student) {
        Session session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();

        return  0;
    }

    @Override
    public int update(Student student) {
        Session session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();

        Scanner myObj = new Scanner(System.in);

        student.setTen(myObj.nextLine());
        student.setGtinh(myObj.nextLine());
        myObj.nextLine();
        student.setTuoi(myObj.nextInt());
        student.setDTB(myObj.nextFloat());
        session.save(student);


        session.getTransaction().commit();
        session.close();
        return 0;
    }

    @Override
    public int delete(Student student) {
        Session session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();

        session.delete(student);

        session.getTransaction().commit();
        session.close();
        return 0;
    }

    @Override
    public ArrayList<Student> selectAll() {
        Session session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("FROM student");

        List<Student> list =q.getResultList();

        session.getTransaction().commit();
        session.close();
        return (ArrayList<Student>)list;
    }

    @Override
    public Student selectById(Student student) {
        Session session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("FROM student WHERE mssv = " + student.getMss());
        List<Student> list =q.getResultList();
        Student s = list.get(0);
        session.getTransaction().commit();
        session.close();
        return s;
    }

    @Override
    public ArrayList<Student> selectByCondition(String condition) {
        Session session = HibernateUtils.getFactory().openSession();
        session.beginTransaction();

        Query q = null;
        if(condition.equals("ten")){
            q = session.createQuery("FROM student WHERE ten = " + condition);
        }else  if(condition.equals("tuoi")){
            q = session.createQuery("FROM student WHERE tuoi = " + condition);
        }else  if(condition.equals("DTB")){
            q = session.createQuery("FROM student WHERE DTB = " + condition);
        }else  if(condition.equals("gtinh")){
            q = session.createQuery("FROM student WHERE gtinh = " + condition);
        }
        List<Student> list =q.getResultList();


        session.getTransaction().commit();
        session.close();
        return (ArrayList<Student>) list;
    }
}
