package edu.tdtu.lab08_02.Controller;


import edu.tdtu.lab08_02.Entity.Employee;
import edu.tdtu.lab08_02.Service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class indexController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String employees(ModelMap model){
        List<Employee> list = employeeService.gettAll();
        model.addAttribute("list" , list);
        return "index";
    }



    @DeleteMapping("/employee/delete/{phone}")
    public String employeeDelete(ModelMap model,@PathVariable("phone") String phone){
        employeeService.delete(phone);
        List<Employee> list = employeeService.gettAll();
        model.addAttribute("list" , list);
        return "index";
    }

    @GetMapping("/edit")
    public String edit(ModelMap model,@RequestParam("id") Long id){
        Employee e = new Employee();
        if(id == 0){

        }else{
            e = employeeService.get(id);
        }
        model.addAttribute("employee" , e);
        return "add";
    }


}
