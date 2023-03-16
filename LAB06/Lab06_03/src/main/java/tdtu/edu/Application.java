package tdtu.edu;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {
public static void main(String[] args) {
	ApplicationContext applicationContext = 
		      new AnnotationConfigApplicationContext(AppConfig.class);
	 
	TextWriter t1 = (PlainTextWriter) applicationContext.getBean("PlainTextWriter");
	try {
		t1.write("hello anh em", "sprint.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
}
