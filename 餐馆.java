// 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 
// 有m批客人，每批客人有两个参数:b人数，c预计消费金额。 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
// 输入描述:
// 输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 
// 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。 
// 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
import java.util.*;
public class Main{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++) {
            arr[i] = sc.nextInt();
        }
        int[][] guest = new int[m][2];
        for(int i = 0;i < m;i++) {
            guest[i][0] = sc.nextInt();
            guest[i][1] = sc.nextInt();
        }
        long res = 0;
        res = maxMoney(arr,guest,n,m);
        System.out.print(res);
    }
    public static long maxMoney(int[] arr,int[][] guest,int n,int m) {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i :arr){
            list.add(i);
        }
        Arrays.sort(guest,(a,b) -> {
            return a[1]==b[1]?b[0] - a[0]:b[1] - a[1];
        });
        long ret = 0;
        for(int i = 0;i < m;i++) {
            int person = guest[i][0];
            int index = find(list,person);
            if(index != -1) {
                ret += guest[i][1];
                list.remove(index);
            }
        }
        return ret;
    }
    public static int find(ArrayList<Integer> list,int person) {
        int left = 0;
        int right = list.size() - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(list.get(mid) >= person) {
                if(mid != 0) {
                    if(list.get(mid-1) >= person){
                        right = mid - 1;
                    }else{
                        return mid;
                    }
                }else{
                    return mid;
                }
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
