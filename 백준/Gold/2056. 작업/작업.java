import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] list;
    static int[] indegree, count, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        list = new ArrayList[n+1];
        indegree = new int[n+1];
        count = new int[n+1];
        time = new int[n+1];
        for(int i = 0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int t = Integer.parseInt(st.nextToken());
            int afterCount = Integer.parseInt(st.nextToken());
            time[i] = t;
            for(int j = 0; j<afterCount; j++){
                int after = Integer.parseInt(st.nextToken());
                list[after].add(i);
                indegree[i]++;
            }
        }
        sort();
        int max = 0;
        for(int i = 1; i<=n; i++){
            max = Math.max(max, count[i]);
        }
        System.out.println(max);
    }
    public static void sort(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0){
                queue.add(i);
                count[i] = time[i];
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i = 0; i<list[cur].size(); i++){
                int next = list[cur].get(i);
                indegree[next]--;
                count[next] = Math.max(count[next], count[cur] + time[next]);
                if(indegree[next] == 0){
                    queue.add(next);
                }
            }
        }

    }
}