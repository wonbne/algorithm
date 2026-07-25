import java.util.*;

class Solution {  
    static boolean[] visited;
    static int n;
    static String[][] ticket;
    static ArrayList<List<String>> list;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        n = tickets.length;
        ticket = tickets;
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        List<String> li = new ArrayList<>();
        
        Arrays.sort(ticket, (a,b) ->{
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        for(int i = 0; i<tickets.length; i++){
            if(ticket[i][0].equals("ICN")){
                visited[i] =true;
                li.add(ticket[i][0]);
                li.add(ticket[i][1]);
                dfs(ticket[i][1],2,li);
                li.remove(li.size()-1);
                li.remove(li.size()-1);
                visited[i] =false;
            }
        }
        
        
        answer = list.get(0).toArray(new String[0]);
        return answer;
    }
    
    public void dfs(String s, int count, List<String> li){
        if(count == n+1){
            list.add(new ArrayList<>(li));
            return;
        }
        
        
        for(int i = 0; i<n; i++){
            if(visited[i] == true){
                continue;
            }
            
            if(s.equals(ticket[i][0])){
                visited[i] = true;
                li.add(ticket[i][1]);
                dfs(ticket[i][1], count+1, li);
                li.remove(li.size()-1);
                visited[i] = false; 
            }
            

        }
    }
}