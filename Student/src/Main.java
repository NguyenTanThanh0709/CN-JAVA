import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\n\n          Student Manager Menu");
            System.out.println("1: Print list student");
            System.out.println("2: insert");
            System.out.println("3: delete");
            System.out.println("4: update");
            System.out.println("5: exit");
            String in = input.next();
            if(in.equals("5")){
                break;
            }
            getInput(in); // Get user input from the keyboard
        }
        while(true);
    }

    public  static  void insert(){
        Scanner input = new Scanner(System.in);
        String mssv = input.next();
        String name = input.next();
        String gtinh = input.next();
        int tuoi = input.nextInt();
        float dtb = input.nextFloat();
        MySQL.addStudent(mssv,name,gtinh,tuoi,dtb);
    }

    public  static  void update(){
        Scanner input = new Scanner(System.in);
        System.out.println("nhap vao mssv muon update: ");
        String mssv = input.next();
        String name = input.next();
        String gtinh = input.next();
        int tuoi = input.nextInt();
        float dtb = input.nextFloat();
        MySQL.update(mssv,name,gtinh,tuoi,dtb);
    }

    public static void delete(){
        Scanner input = new Scanner(System.in);
        System.out.println("nhap mssv muon xoa");
        String mssv = input.next();
        MySQL.delete(mssv);
    }

    private static void getInput(String input) {
        int num = Integer.parseInt(input);
        switch(num) {
            case 1:
                List <Student> listStudent  = new ArrayList<Student>();
                listStudent = MySQL.addStudentFromDTB();
                MySQL.PrintListStudent(listStudent);
                break;
            case 2:
                insert();
                break;
            case 3:
                delete();
                break;
            case 4:
                update();
                break;

            default:
                System.out.print("The entered value is unrecognized!");
                break;
        }
    }
}
