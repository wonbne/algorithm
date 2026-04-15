import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] time, result, indegrees;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        time = new int[n+1];
        result = new int[n+1];
        indegrees = new int[n+1];
        list = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            time[i] = a;
            result[i] = a;
            while(true){
                a = Integer.parseInt(st.nextToken());
                if(a == -1) break;
                list[a].add(i);
                indegrees[i]++;
            }
        }
        sort();
        for(int i : result){
            if(i == 0) continue;
            System.out.println(i);
        }
    }

    public static void sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i : list[tmp]){
                indegrees[i]--;
                result[i] = Math.max(result[i], result[tmp] + time[i]);
                if(indegrees[i] == 0){
                    q.add(i);
                }
            }
        }
    }

}