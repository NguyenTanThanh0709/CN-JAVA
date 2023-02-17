import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Main {

	public static void UpdateStudent(int idStudent, ArrayList<Student> list, Scanner sc){
		for (Student each : list) {
			if(each.id == idStudent){
				each.inputInfo(sc);
			}
		}
	}

	public static void DeleteSudent(int idStudent, ArrayList<Student> list){
		for (Student each : list) {
			if(each.id == idStudent){
				list.remove(each);
			}
		}
	}

	public static void Search(int idStudent, ArrayList<Student> list){
		for (Student each : list) {
			if(each.id == idStudent){
				each.showInfo();
			}
		}
	}

	

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		boolean cont = true;
        ArrayList<Student> ListStudents = new ArrayList<Student>();
		do {
			int chon = input.nextInt();
			switch (chon) {
			case 1:
				System.out.println("Nhap SV");
                Student st = new Student();
                st.inputInfo(input);
                ListStudents.add(st);
				break;
			case 2:
				System.out.println("Cap Nhat SV");
				UpdateStudent(1, ListStudents, input);
				break;
			case 3:
				System.out.println("Xoa");
				DeleteSudent(1, ListStudents);
				break;
            case 4:
                    System.out.println("Tim SV");
					Search(1, ListStudents);
                    break;
            
			case 5:
            System.out.println("Hiển thị tất cả các Student theo điểm trung bình (GPA) giảm dần");
			Collections.sort(ListStudents, new SortbyGPA()); 

            break;
            
			case 6:
            System.out.println("Sắp xếp Student theo tên trong bảng chữ cái (A → Z)");
			Collections.sort(ListStudents, new SortbyName()); 

            break;
            
			case 7:
            System.out.println(" Sắp xếp Student theo ID");
			Collections.sort(ListStudents, new SortbyID()); 
            break;
            
			case 8:
            System.out.println("Hiển thị danh sách tất cả Student.");
			for (Student student : ListStudents) {
				student.showInfo();
			}
            break;
                
			default:
				System.out.println("Tạm biệt");
				cont = false;
				break;
			}
		} while (cont);
    }
}
