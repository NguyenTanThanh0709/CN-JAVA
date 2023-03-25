package edu.tdtu.lab07_03.Service;

import edu.tdtu.lab07_03.Entity.Student;
import edu.tdtu.lab07_03.Repositoty.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void save(Student s1){
        studentRepository.save(s1);
    }

    public List<Student> getAll(){
        List<Student> list = studentRepository.findAll();
        return list;
    }

    public void delete(long s1){
        studentRepository.deleteById(s1);
    }


    // ex4


    public Optional<Student> findById(long l) {
        return studentRepository.findById(l);
    }

    public List<Student> findAge(int age){
        return  studentRepository.findByAgeGreaterThan(age);
    }

    public List<Student> findScore(double score){
        return  studentRepository.findByIeltsScore(score);
    }

    public List<Student> findName(String name){
        return  studentRepository.findByNameContaining(name);
    }


    // ex5

    public Collection<Student> getAge(int age){
        return studentRepository.searchAge(age);
    }

    public Collection<Student> getIeltsScore(double age){
        return studentRepository.searchIelts(age);
    }

    public Collection<Student> getName(String age){
        return studentRepository.searchName(age);
    }

    // ex6

    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll(Sort.by("age")
                .descending()
                .and((Sort.by("ieltsScore")) ));
    }

    public Iterable<Student> getCustomeStudent(){
        Pageable page = PageRequest.of(0,10,Sort.by("age")
                .descending()
                .and(Sort.by("ieltsScore")));
        Page<Student> studentPage = studentRepository.findAll(page);
        return studentPage.getContent().subList(4,7);
    }


}
