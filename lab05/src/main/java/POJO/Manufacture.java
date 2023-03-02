package POJO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import POJO.Phone;

@Entity
@Table(name = "Manufacture")
public class Manufacture implements Serializable {
    @Id
    private String Id;
    private String Name;
    private String Location;
    private int Employee;

    @OneToMany(mappedBy = "manufacture")
    private List<Phone> Phone = null;

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

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getEmployee() {
        return Employee;
    }

    public void setEmployee(int employee) {
        Employee = employee;
    }

    public List<Phone> getPhone() {
        return Phone;
    }

    public void setPhone(List<Phone> phone) {
        Phone = phone;
    }
}