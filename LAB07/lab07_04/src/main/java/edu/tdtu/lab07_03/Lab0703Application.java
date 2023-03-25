package edu.tdtu.lab07_03;

import edu.tdtu.lab07_03.Entity.Student;
import edu.tdtu.lab07_03.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Lab0703Application {

	@Autowired
	private StudentService service;
	public static void main(String[] args) {

		SpringApplication.run(Lab0703Application.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {

			// ex3
			service.save(new Student(1L,"thanh",22,"2",2.8f));
			service.save(new Student(2L,"hung",2,"2",9.0f));
			service.save(new Student(3L,"nam",23,"2",2.8f));
			service.save(new Student(4L,"thanh",2,"2",6.0f));
			service.save(new Student(5L,"212",12,"2",2.8f));
			service.save(new Student(6L,"212",2,"2",2.8f));

			List<Student> list = service.getAll();
			for (Student sa:list
			) {
				System.out.println(sa.getAge());
			}


			// update Student

			Student studentToUpdate =  service.findById(1L).get();
			studentToUpdate.setAge(21);
			studentToUpdate.setIeltsScore(7);
			service.save(studentToUpdate);
			System.out.println("Updated student:");
			System.out.println(service.findById(1L).get().getAge());


			// Delete a student from the database and print the result after deleting
			service.delete(3L);
			System.out.println("Students found with findAll() after deleting one:");
			System.out.println("-------------------------------");
			for (Student student : service.getAll()) {
				System.out.println(student);
			}
			System.out.println();


			// ex4

			List<Student> list12 = service.findAge(2);
			for (Student student : list12) {
				System.out.println(student);
			}

			List<Student> list122 = service.findScore(2.0);
			for (Student student : list122) {
				System.out.println(student);
			}

			List<Student> list__ = service.findName("thanh");
			for (Student student : list__) {
				System.out.println(student);
			}

		};
	}

}
