package tdtu.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class application {
public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(applicationConfig.class);
    Product p = (Product)context.getBean("product1");
    
    System.out.println(p.getName());
}
}
