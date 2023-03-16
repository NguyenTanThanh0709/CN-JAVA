package lab07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab07.dto.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{

}

