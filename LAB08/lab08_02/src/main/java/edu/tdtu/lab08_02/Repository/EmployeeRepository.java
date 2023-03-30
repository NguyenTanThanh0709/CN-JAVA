package edu.tdtu.lab08_02.Repository;

import edu.tdtu.lab08_02.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findByPhone(String phone);
}
