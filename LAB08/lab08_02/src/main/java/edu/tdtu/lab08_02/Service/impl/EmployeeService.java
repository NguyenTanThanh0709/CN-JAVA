package edu.tdtu.lab08_02.Service.impl;

import edu.tdtu.lab08_02.Entity.Employee;
import edu.tdtu.lab08_02.Repository.EmployeeRepository;
import edu.tdtu.lab08_02.Service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> gettAll() {
        return  employeeRepository.findAll();
    }

    @Override
    public Employee getOne(String phone) {
        return employeeRepository.findByPhone(phone);
    }

    @Override
    public Employee update(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public  Employee get(Long id){
        if(id == null){
            return null;
        }
        return employeeRepository.findById(id).get();
    }

    @Override
    public void delete(String phone) {
        Employee e = employeeRepository.findByPhone(phone);
        employeeRepository.delete(e);
    }

    @Override
    public void insert(Employee employee) {
        employeeRepository.save(employee);
    }
}
