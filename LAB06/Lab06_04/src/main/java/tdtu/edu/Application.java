package tdtu.edu;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan(basePackages = "tdtu.edu")
@Configuration

public class Application {
	private static ApplicationContext applicationContext;
public static void main(String[] args) {
	applicationContext = 
	          new AnnotationConfigApplicationContext(Application.class);

	        for (String beanName : applicationContext.getBeanDefinitionNames()) {
	            System.out.println(beanName);
	        }
	 
	        TextWriter t1 = (PlainTextWriter) applicationContext.getBean("plainTextWriter");
	    	try {
	    		t1.write("hello anh em bai 4", "spring.txt");
	    	} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	
	
	
}
}
