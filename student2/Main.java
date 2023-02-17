package org.example;

import org.example.Handle.StudentDAO;
import org.example.Hibernate.HibernateUtils;
import org.example.pojo.Student;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");


        StudentDAO stu = StudentDAO.getInstance();
        Student st = new Student();
        st.setMss("123211");
        st.setTen("huhu1");
        st.setGtinh("nam");
        st.setTuoi(12);
        st.setDTB(1.5f);

        stu.delete(st);
    }
}