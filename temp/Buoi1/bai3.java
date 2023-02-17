import java.util.Scanner;

class bai3 {
private static int TIEN =1000;

private static int TIEN_PHAT = 1200;
 private static int SO_DIEN_PHAT = 50;

 public static void solution(){
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

public static void main(String[] args) {

solution();
}
}
