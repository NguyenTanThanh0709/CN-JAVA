package edu.tdtu.lab08_02.Controller;

import edu.tdtu.lab08_02.Entity.Employee;
import edu.tdtu.lab08_02.Service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class apiController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee/add")
    public Employee employeesadd(@RequestBody Employee employee){
        employeeService.insert(employee);
        return  employee;
    }

    @PutMapping("/employee/update/{id}")
    public Employee employeeUpdate(@PathVariable("id") long id, @RequestBody Employee employee){
        employee.setId(id);
        employeeService.update(employee);
        return  employee;
    }
}
