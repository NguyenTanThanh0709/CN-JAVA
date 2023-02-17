import java.util.Random;

public class CheckPrimeNumber{


    public static boolean isPrime(int n, int i)
    {
        // Base cases
        if (n <= 2) 
           return (n == 2) ? true : false; 
       if (n % i == 0) 
           return false; 
       if (i * i > n)

            return true;
        // Check for next divisor
        return isPrime(n, i + 1);
    }


    public static void EnterArrayRandom(int[] array, int n){
        Random rand = new Random();
        for(int i = 0; i <n; i++ ){ 
             array[i]=rand.nextInt(100);
        }
    }


    public static void showIsPrimeNumber(int[] array, int n){
        for(int i = 0; i < n; i++){
            if(isPrime(array[i], 2)){
                System.out.println(array[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        EnterArrayRandom(array, 10);
    }

}