package tdtu.edu.lab07_02.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.lab07_02.Entity.Student;
import tdtu.edu.lab07_02.Repository.StudentRepository;
import tdtu.edu.lab07_02.Service.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll(){
        return (List<Student>) studentRepository.findAll();
    }

    public void save(Student s){
        studentRepository.save(s);
    }

    public void deleteById(long l){
        studentRepository.deleteById(l);
    }

    public Optional<Student> findById(long l){
        return studentRepository.findById(l);
    }
}
