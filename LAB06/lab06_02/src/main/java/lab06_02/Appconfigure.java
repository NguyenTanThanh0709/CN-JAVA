package lab06_02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Appconfigure {
	
	@Bean
	@Scope("prototype")
	public Product product1() {
		Product pro = new Product();
		pro.setId("1");
		pro.setName("iphone");
		return pro;
	}
	
	@Bean
	@Scope("prototype")
	public Product product2() {
		
		return new Product("2", "ip2", "");
	}
	
	@Bean
	@Scope("singleton")
	public Product product3() {
		
		return new Product("3", "ip3", "");
	}

}
