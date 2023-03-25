package tdtu.edu.lab07_02.Service;

import tdtu.edu.lab07_02.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    public List<Student> getAll();

    public void save(Student s);

    void deleteById(long l);

    Optional<Student> findById(long l);
}
