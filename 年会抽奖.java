import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            float res = (literal(n)/jie(n)) * 100;
            System.out.println(String.format("%.2f", res) + "%");
        }
    }
    public static float jie(int n) {
        if(n==0){
            return 1;
        }else{
            return n * jie(n-1);
        }
    }
    public static float literal(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }else{
            return (n-1) * (literal(n-1)+literal(n-2));
        }
    }
}
