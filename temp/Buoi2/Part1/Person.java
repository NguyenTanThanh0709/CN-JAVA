import java.util.Scanner;

public class Person {
    // Thuoc tinh
    protected String name;
    protected int age;
    protected String Gender;

    // Phuong thuc
    // Ham khoi tao khong doi so
    public Person() {

    }

    // Ham khoi tao co doi so
    public Person(String name, int age, String Gender) {
        this.name = name;
        this.age = age;
        this.Gender = Gender;
    }

    // Cac ham getter va setter cho cac thuoc tinh

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    // Ham hien thi thong tin
    public void showInfo() {
        System.out.println("\tHo ten: " + name);
        System.out.println("\tTuoi: " + age);
        System.out.println("\tDia chi: " + Gender);
    }

    // Ham nhap thong tin
    public void inputInfo(Scanner sc) {
        System.out.print("\tNhap ho ten: ");
        sc.nextLine();
        name = sc.nextLine();
        System.out.print("\tNhap tuoi: ");
        age = sc.nextInt();
        System.out.print("\tNhap Gioi tinh: ");
        sc.nextLine();
        Gender = sc.nextLine();
    }
}
