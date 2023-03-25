package tdtu.edu.lab07_02.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.lab07_02.Entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}