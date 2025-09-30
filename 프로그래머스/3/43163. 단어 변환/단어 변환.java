import java.util.*;
class Solution {
    int answer = 0;
    boolean[] visited;
    int step = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        boolean found = false;
        for (String w : words) {
            if (w.equals(target)) {
                found = true;
                break;
            }
        }
        if (!found) return 0;
        bfs(begin, target, words);
        return step;
    }
    public void bfs(String begin, String target, String[] words){
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        step=0;
        while(!q.isEmpty()){
            int size = q.size();
            step++;
            for(int j = 0; j<size; j++){
                String cur = q.poll();
                for(int i = 0; i<words.length; i++){
                    if(!visited[i] && canConvert(cur, words[i])){
                        visited[i] = true;
                        if(words[i].equals(target)) return;
                        q.add(words[i]);
                    }
                }
            }
           
        }
         step = 0;
    }
    public boolean canConvert(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}