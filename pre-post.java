import java.util.*;
 
public class Main {
    private static long num = 1;
    private static long numArr[];
 
    public static void main(String[] args) {
        initArr();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            String preOrder = sc.next();
            String postOrder = sc.next();
            num = 1;
            CaculateTree(n, preOrder, postOrder);
            System.out.println(num);
        }
    }
    private static void CaculateTree(int n, String preOrder, String postOrder) {
        int len = preOrder.length();
        if (len == 1) {
            return;
        }
        int count = 0;
        preOrder = preOrder.substring(1);
        postOrder = postOrder.substring(0,len-1);
        while (!"".equals(preOrder)) {
            int index = postOrder.indexOf(preOrder.charAt(0))+1;
            String newPre = preOrder.substring(0,index);
            String newPost = postOrder.substring(0,index);
            preOrder = preOrder.substring(index);
            postOrder = postOrder.substring(index);
            count++;
            CaculateTree(n, newPre, newPost);
        }
        num *= CaculateCom(count, n);
    }
    private static void initArr() {
        numArr = new long[21];
        numArr[0] = 1;
        for (int i = 1; i < 21; i++) {
            numArr[i] = numArr[i - 1] * i;
        }
    }
    private static long CaculateCom(int subNum, int n) {
        return numArr[n] / (numArr[n - subNum] * numArr[subNum]);
    }
}
