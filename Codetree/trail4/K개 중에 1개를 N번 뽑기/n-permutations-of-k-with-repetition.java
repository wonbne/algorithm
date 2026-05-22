import java.util.Scanner;
import java.util.*;
public class Main {
    static int k,n;
    static List<int[]> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        list = new ArrayList<>();
        int[] tmp = new int[n+1];
        dfs(1, tmp);
        for(int i = 0; i<list.size(); i++){
            for(int j = 1; j<= n; j++){
                System.out.print(list.get(i)[j]+" ");
            }
            System.out.println();
        }
    }
    public static void dfs(int depth, int[] tmp){
        if(depth == n+1){
            list.add(tmp.clone());
            return ;
        }
        for(int i = 1; i<=k; i++){
            tmp[depth] = i;
            dfs(depth+1, tmp);
        }

    }
}