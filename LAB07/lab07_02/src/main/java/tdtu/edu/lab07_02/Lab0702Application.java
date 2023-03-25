package tdtu.edu.lab07_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tdtu.edu.lab07_02.Entity.Student;
import tdtu.edu.lab07_02.Service.IStudentService;
import tdtu.edu.lab07_02.Service.impl.StudentService;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Lab0702Application {

	@Autowired
	private StudentService service;
	public static void main(String[] args) {
		SpringApplication.run(Lab0702Application.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			service.save(new Student(1L,"212",2,"2",2.8f));
			service.save(new Student(1L,"212",2,"2",2.8f));
			service.save(new Student(1L,"212",2,"2",2.8f));
			List<Student> list = service.getAll();
			for (Student sa:list
				 ) {
				System.out.println(sa.getAge());
			}

			Student studentToUpdate =  service.findById(1L).get();
			studentToUpdate.setAge(21);
			studentToUpdate.setIeltsScore(7);
			service.save(studentToUpdate);
			System.out.println("Updated student:");
			System.out.println(service.findById(1L).get().getAge());


			// Delete a student from the database and print the result after deleting
			service.deleteById(3L);
			System.out.println("Students found with findAll() after deleting one:");
			System.out.println("-------------------------------");
			for (Student student : service.getAll()) {
				System.out.println(student);
			}
			System.out.println();


		};
	}
}
