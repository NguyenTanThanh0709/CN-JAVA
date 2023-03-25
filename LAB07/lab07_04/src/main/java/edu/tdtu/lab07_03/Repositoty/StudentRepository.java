package edu.tdtu.lab07_03.Repositoty;

import edu.tdtu.lab07_03.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByAgeGreaterThan(int age);

    public  List<Student> findByIeltsScore(double score);

    public  List<Student> findByNameContaining(String name);


}
