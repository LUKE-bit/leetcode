//工作中，每当要部署一台新机器的时候，就意味着有一堆目录需要创建。例如要创建目录“/usr/local/bin”，就需要此次创建“/usr”、“/usr/local”以及“/usr/local/bin”。好在，Linux下mkdir提供了强大的“-p”选项，只要一条命令“mkdir -p /usr/local/bin”就能自动创建需要的上级目录。
//现在给你一些需要创建的文件夹目录，请你帮忙生成相应的“mkdir -p”命令。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            in.nextLine();
            String[] arr = new String[n];
            for(int i = 0;i < n;i++) {
                arr[i] = in.nextLine();
            }
            Arrays.sort(arr);
            for(int j = 1;j < n;j++) {
                if(!arr[j].contains(arr[j-1])){
                    System.out.println("mkdir -p " + arr[j-1]);
                }else if(arr[j].charAt(arr[j-1].length())!='/'){
                    System.out.println("mkdir -p " + arr[j-1]);
                }
            }
            System.out.println("mkdir -p " + arr[n-1]);
            System.out.println();
        }
    }
}
