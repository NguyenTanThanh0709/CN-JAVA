package lab07.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lab07.dto.Student;
import lab07.repository.StudentRepository;

@Component
public class StudentDAO {

	@Autowired
    private StudentRepository strepo;
	
	public void insert(Student student) {
		strepo.save(student);
    }

    public ArrayList<Student> getAll() {
        return (ArrayList<Student>) strepo.findAll();
    }

    public void delete(String id) {
    	strepo.delete(id);
    }

}
