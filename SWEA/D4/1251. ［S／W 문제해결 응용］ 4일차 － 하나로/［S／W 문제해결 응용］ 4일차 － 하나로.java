import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int n;
    static double e;
    static int[] parent;
    static List<Node> nodes;
    static List<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            parent = new int[n+1];
            for(int i = 0; i<=n; i++){
                parent[i] = i;
            }
            nodes = new ArrayList<>();
            edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nodes.add(new Node());
            }
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < n; i++) {
                nodes.get(i).x = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < n; i++) {
                nodes.get(i).y = Integer.parseInt(st.nextToken());
            }
            e = Double.parseDouble(br.readLine().trim());

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    long dx = nodes.get(i).x - nodes.get(j).x;
                    long dy = nodes.get(i).y - nodes.get(j).y;
                    long weight = dx * dx + dy * dy;
                    edges.add(new Edge(i, j, weight));

                }
            }
            Collections.sort(edges, (a, b) -> Long.compare(a.weight, b.weight));
            double min = 0;
            for(int i = 0; i<edges.size(); i++){
                if(find(edges.get(i).start) != find(edges.get(i).end)){
                    min += e * edges.get(i).weight;
                    union(edges.get(i).start, edges.get(i).end);
                }
            }
            System.out.println("#"+tc+" "+ Math.round(min));
        }
    }

    static void union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);

        if(root1 != root2){
            parent[root1] = root2;
        }
    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static class Node {
        int x;
        int y;
    }

    static class Edge {
        int start;
        int end;
        long weight;

        public Edge(int start, int end, long weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}