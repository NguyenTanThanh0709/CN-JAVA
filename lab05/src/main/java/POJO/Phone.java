package POJO;


import javax.persistence.*;
import java.io.Serializable;
import POJO.Manufacture;
@Entity
@Table(name = "Phone")
public class Phone implements Serializable {
    @Id
    private String Id;
    private String Name;
    private  int Price;
    private String Image;
    private  String Color;
    private  String Country;
    private int Quanlity;


    @ManyToOne
    @JoinColumn(name = "Id_Manufacture")
    private Manufacture manufacture;

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getQuanlity() {
        return Quanlity;
    }

    public void setQuanlity(int quanlity) {
        Quanlity = quanlity;
    }

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

   
}