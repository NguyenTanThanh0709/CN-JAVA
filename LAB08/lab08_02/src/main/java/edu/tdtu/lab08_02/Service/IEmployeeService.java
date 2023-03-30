package edu.tdtu.lab08_02.Service;

import edu.tdtu.lab08_02.Entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> gettAll();
    public Employee getOne(String phone);
    public  Employee update(Employee employee);
    public void delete(String phone);
    public  void insert(Employee employee);
}
