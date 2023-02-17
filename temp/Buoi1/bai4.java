import java.text.DecimalFormat;
import java.util.Scanner;

public class bai4 {

    private static int TIEN =1000;

    private static int TIEN_PHAT = 1200;
     private static int SO_DIEN_PHAT = 50;
    public static void gtb1(){
        int aNumber, bNumber;
        double nghiem;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");    // làm tròn đến 2 chữ số thập phân
        Scanner scanner = new Scanner(System.in);
         
        System.out.println("Nhập vào số a: ");
        aNumber = scanner.nextInt();
        System.out.println("Nhập vào số b: ");
        bNumber = scanner.nextInt();
        System.out.println("Phương trình bạn vừa nhập vào là: " + aNumber + "x + " + bNumber + " = 0.");
        if (aNumber == 0) {
            if (bNumber == 0) {
                System.out.println("Phương trình này có vô số nghiệm.");
            } else {
                System.out.println("Phương trình vô nghiệm.");
            }
        } else {
            nghiem = (double) -bNumber / aNumber;   // ép kiểu để cho ra kết quả chính xác
            System.out.println("Phương trình có nghiệm x = " + decimalFormat.format(nghiem) + ".");
        }
    }

    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập hệ số bậc 2, a = ");
        float a = scanner.nextFloat();
        System.out.print("Nhập hệ số bậc 1, b = ");
        float b = scanner.nextFloat();
        System.out.print("Nhập hằng số tự do, c = ");
        float c = scanner.nextFloat();
        giaiPTBac2(a, b, c);
    }
     
    /**
     * Giải phương trình bậc 2: ax2 + bx + c = 0
     * 
     * @param a: hệ số bậc 2
     * @param b: hệ số bậc 1
     * @param c: số hạng tự do
     */
    public static void giaiPTBac2(float a, float b, float c) {
        // kiểm tra các hệ số
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình vô nghiệm!");
            } else {
                System.out.println("Phương trình có một nghiệm: "
                        + "x = " + (-c / b));
            }
            return;
        }
        // tính delta
        float delta = b*b - 4*a*c;
        float x1;
        float x2;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            System.out.println("Phương trình có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2);
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            System.out.println("Phương trình có nghiệm kép: "
                    + "x1 = x2 = " + x1);
        } else {
            System.out.println("Phương trình vô nghiệm!");
        }
    }

    public static void gtb3(){
        int soDien = 0;

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Vui long nhap so dien = ");
        
        soDien = sc.nextInt();
        
        if (soDien < SO_DIEN_PHAT) {
        
        System.out.println("So tien dien = + soDien * TIEN");
        
        } else {
        int result = SO_DIEN_PHAT * TIEN + (soDien - SO_DIEN_PHAT) * TIEN_PHAT;
        
        System.out.println("So tien dien = " + result);
        
        
        }
    }



    public static void main (String[] args) throws java.io.IOException{
        char choice;/*from  w w  w  .j  ava2  s. c  om*/

    do {
      System.out.println("Menu:");
      System.out.println("  1. b1");
      System.out.println("  2. b2");
      System.out.println("  3. b3");

      System.out.println("Choose one:");
      choice = (char) System.in.read();
    } while( choice < '1' || choice > '3');

    System.out.println("\n");
 
    switch(choice) {
      case '1':
        System.out.println("1\n");
        gtb1();
        break;
      case '2':
        System.out.println("2:\n");
        solution();
        break;
      case '3':
        System.out.println("3:\n");
        gtb3();
        break;
    }
    }
}