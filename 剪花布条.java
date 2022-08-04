import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String cloth0 = in.next();
            String cloth1 = in.next();
            int count = 0;
            int i = 0;
            while(i < cloth0.length()) {
                if(cloth1.charAt(0) == cloth0.charAt(i)) {
                    int last = i;
                    int j = 0;
                    boolean flag = false;
                    for(j = 0;j < cloth1.length();j++) {
                        if(i+j<cloth0.length() && cloth1.charAt(j) != cloth0.charAt(last)) {
                            flag = true;
                            break;
                        }
                        last++;
                    }
                    if(i+j<cloth0.length()+1 && !flag){
                        count++;
                        i+=cloth1.length();
                    }else i++;
                }else{
                    i++;
                }
            }
            System.out.println(count);
        }
    }
}
