package org.example;

import org.example.Handle.StudentDAO;
import org.example.Hibernate.HibernateUtils;
import org.example.pojo.Student;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

//        Session session = HibernateUtils.getFactory().openSession();

        StudentDAO stu = StudentDAO.getInstance();
        Student ne = new Student("119","","",12,1.0f);
        stu.selectById(ne);
        System.out.println(ne);

//        stu.delete(st);
    }
}