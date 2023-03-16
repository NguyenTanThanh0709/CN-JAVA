package lab07.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab07.dao.StudentDAO;
import lab07.dto.Student;

@Controller
public class HomeController {
	
	@Autowired
	private StudentDAO dao;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("home");
		ArrayList<Student> students = dao.getAll();
		mav.addObject("Student", students);
		
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam String id) {
		dao.delete(id);
		return homePage();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(@RequestParam String phone, @RequestParam String name, @RequestParam String department) {
		Student st = new Student();
    	st.setPhone(phone);
    	st.setName(name);
    	st.setDepartment(department);
        dao.insert(st);
		return homePage();
	}
}
