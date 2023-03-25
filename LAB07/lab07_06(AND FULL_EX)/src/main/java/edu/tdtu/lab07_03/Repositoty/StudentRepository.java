package edu.tdtu.lab07_03.Repositoty;

import edu.tdtu.lab07_03.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByAgeGreaterThan(int age);

    public  List<Student> findByIeltsScore(double score);

    public  List<Student> findByNameContaining(String name);

    @Query("SELECT s FROM Student s where s.age >= :age")
    public Collection<Student>  searchAge(@Param(("age")) int age);

    @Query("SELECT s FROM Student s where s.ieltsScore >= :ieltsScore")
    public Collection<Student>  searchIelts(@Param(("ieltsScore")) double ieltsScore);

    @Query("SELECT s FROM Student s where s.name like %:name%")
    public Collection<Student>  searchName(@Param(("name")) String name);



}
