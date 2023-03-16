package tdtu.edu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;


@Configuration
@PropertySource("classpath:application.properties")
public class applicationConfig {

	@Value("${id}")
	private String id;
	@Value("${name}")
	private String name;
	@Value("${des}")
	private String des;
	
	@Bean
	@Scope("prototype")
	public Product product1() {
		return new Product(
				String.valueOf(this.id),
				String.valueOf(this.name),
				String.valueOf(this.des)
				
				);
	}
	
	@Bean
	@Scope("prototype")
	public Product product2() {
		return new Product(
				
				product1()
				);
	}

}
