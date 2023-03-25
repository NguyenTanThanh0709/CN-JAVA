package edu.tdtu.lab07_03.Service;

import edu.tdtu.lab07_03.Entity.Student;
import edu.tdtu.lab07_03.Repositoty.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
