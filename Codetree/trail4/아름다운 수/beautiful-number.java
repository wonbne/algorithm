import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        dfs(0);
        System.out.println(total);
    }

    public static void dfs(int count){
        if(count == n){
            total++;
            return;
        }

        for(int i = 1; i<=4; i++){
            if(count + i <= n){
                dfs(count+i);
            }
        }

    }

}