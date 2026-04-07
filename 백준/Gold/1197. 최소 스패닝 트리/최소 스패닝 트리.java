import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int v, e, min;
    static int[] parent;
    static List<int[]> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parent = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            parent[i] = i;
        }
        edges= new ArrayList<>();
        min = 0;

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new int[]{start, end, weight});
        }
        Collections.sort(edges,(a,b)->Integer.compare(a[2],b[2]));
        int count = 0;
        for(int i = 0; i<edges.size(); i++){
            if(find(edges.get(i)[0]) != find(edges.get(i)[1])){
                min += edges.get(i)[2];
                union(edges.get(i)[0], edges.get(i)[1]);
                count++;
                if(count == v-1) break;
            }
        }

        System.out.println(min);
    }

    static void union(int a, int b) {
        int node1 = find(a);
        int node2 = find(b);

        if(node1 != node2){
            parent[node1] = node2;
        }
    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}