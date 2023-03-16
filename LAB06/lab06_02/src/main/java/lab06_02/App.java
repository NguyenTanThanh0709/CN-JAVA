package lab06_02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;


@Configuration
public class App {

	public static void main(String[] args) {
		 ApplicationContext applicationContext = 
			      new AnnotationConfigApplicationContext(Appconfigure.class);
		 
		 Product p1 = (Product) applicationContext.getBean("product1");
		 Product p2 = (Product) applicationContext.getBean("product2");
		 Product p3 = (Product) applicationContext.getBean("product3");
		 System.out.println(p1.getName());
		 System.out.println(p2.getName());
		 System.out.println(p3.getName());
		 
		 
		 
	}
}
