import java.util.Comparator;
import java.util.Scanner;


public class Student extends Person {
    // Thuoc tinh
    private double math, physics, chemistry, average;
    public int id;

    // Phuong thuc
    // Ham khoi tao khong doi so
    public Student() {

    }

    // Ham khoi tao co doi so
    public Student(int id, String name, int age, double math, double physics, double chemistry) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        average = (math + physics + chemistry) / 3;
    }

    // getter cho average
    public double getAverage() {
        return average;
    }

    // getter cho math
    public double getMath() {
        return math;
    }

    // Ham hien thi
    public void display() {
        super.showInfo();
        System.out.println("\tID " + id);
        System.out.println("\tDiem toan: " + math);
        System.out.println("\tDiem vat ly: " + physics);
        System.out.println("\tDiem hoa hoc: " + chemistry);
        System.out.println("\tDiem trung binh: " + average);
    }



    // Ham nhap thong tin
    public void enter(Scanner sc) {
        super.inputInfo(sc);
        System.out.print("\tNhap id: ");
        this.id = sc.nextInt();
        System.out.print("\tNhap diem toan: ");
        math = sc.nextDouble();
        System.out.print("\tNhap diem ly: ");
        physics = sc.nextDouble();
        System.out.print("\tNhap diem hoa: ");
        chemistry = sc.nextDouble();
        average = (math + physics + chemistry) / 3;
    }

    public void showClassification(){
        if(average >= 8){
            System.out.println("gioi");
        }else if(average < 8 && average >=6.5){
            System.out.println("kha");
        }else if(average < 6.5 && average >=5){
            System.out.println("trung binh");
        }else{
            System.out.println("Yeu");
        }
    }
}

class SortbyGPA implements Comparator<Student> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Student a, Student b) 
    { 
        return (int) (a.getAverage() - b.getAverage()); 
    } 
} 

class SortbyName implements Comparator<Student> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(Student a, Student b) 
    { 
        if((int) a.getName().charAt(0) > (int) b.getName().charAt(0)){
            return 1;
        }else{
            return 0;
        }
    } 
} 

class SortbyID implements Comparator<Student> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Student a, Student b) 
    { 
        return (int) (a.id - b.id); 
    } 
} 