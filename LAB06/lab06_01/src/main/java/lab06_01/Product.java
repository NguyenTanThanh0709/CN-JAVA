package lab06_01;

public class Product {
	private String id;
	private String name;
	private String des;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Product(String id, String name, String des) {
		
		this.id = id;
		this.name = name;
		this.des = des;
	}
	
public Product() {
		

	}
	
	public Product(Product pro) {
		
		this.id = pro.id;
		this.name = pro.name;
		this.des = pro.des;
	}
	
	
}
