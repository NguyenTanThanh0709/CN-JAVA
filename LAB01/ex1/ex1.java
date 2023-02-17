public  class ex1 {

    public static void handleCaculate(int num1, int num2, String par){
        double result = -1;
        if(par.equals("+")){
            result = num1 + num2;
        }else if(par.equals("-")){
            result = num1 - num2;

        }else if(par.equals("x")){
            result = num1 * num2;

        }else if(par.equals("/")){
            result = num1 / num2;

        }else if(par.equals("^")){
            result = Math.pow(num1, num2);

        }else {
            System.out.println("error!");
            return;
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        if(args.length != 3){
            System.out.println("error");
            return;
        }
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[2]);
        handleCaculate(num1, num2, args[1]);

    }
}