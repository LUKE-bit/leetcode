搜狐员工小王最近利用假期在外地旅游，在某个小镇碰到一个马戏团表演，精彩的表演结束后发现团长正和大伙在帐篷前激烈讨论，小王打听了下了解到， 
马戏团正打算出一个新节目“最高罗汉塔”，即马戏团员叠罗汉表演。考虑到安全因素，要求叠罗汉过程中，站在某个人肩上的人应该既比自己矮又比自己瘦，或相等。
团长想要本次节目中的罗汉塔叠的最高，由于人数众多，正在头疼如何安排人员的问题。小王觉得这个问题很简单，于是统计了参与最高罗汉塔表演的所有团员的身高体重，
并且很快找到叠最高罗汉塔的人员序列。 
现在你手上也拿到了这样一份身高体重表，请找出可以叠出的最高罗汉塔的高度，这份表中马戏团员依次编号为1到N。
import java.util.*;
public class Main {
     static class Person {
        int height;
        int weight;
 
        public Person(int weight, int height) {
            this.height = height;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            Person[] people = new Person[n]; 
            for(int i = 0;i < n;i++) {
                int index = in.nextInt();
                people[index-1] = new Person(in.nextInt(),in.nextInt());
            }
            Arrays.sort(people,new Comparator<Person>() {
                public int compare(Person o1,Person o2) {
                    int result = Integer.compare(o1.height, o2.height);
                    if (result != 0)
                        return result;
                    else
                        return Integer.compare(o1.weight, o2.weight);
                }
            });
            int[] dp = new int[n];
            int max = Integer.MIN_VALUE;
            for(int i = 0;i < n;i++) {
                dp[i] = 1;
                for(int j = i-1;j >= 0;j--) {
                    if(people[i].weight > people[j].weight 
                       || (people[i].weight== people[j].weight && people[i].height == people[j].height)){
                        dp[i] = Math.max(dp[i],dp[j] + 1);
                    }
                }
                max = Math.max(max,dp[i]);
            }
            System.out.println(max);
        }
    }
}
