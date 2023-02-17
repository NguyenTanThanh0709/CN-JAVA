
public  class ex2 {
    public static void main(String[] args) {
        int[] a = {1,3,5,2};
        int[] b = {2,3};
        ArrayOutput.print(a);
        ArrayHandler.sort(a);
        ArrayOutput.print(a);
        int[] c = ArrayHandler.merge(a,b);
        ArrayOutput.print(c);
        ArrayOutput.write(c,args[0]);


    }
}