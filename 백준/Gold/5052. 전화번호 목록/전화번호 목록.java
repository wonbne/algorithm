import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int n;
    static TrieNode root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<=t; tc++){
            root = new TrieNode();
            n = Integer.parseInt(br.readLine().trim());
            boolean is = true;
            for(int i = 0; i<n; i++){
                String s = br.readLine().trim();
                if(!Insert(s)){
                    is = false;
                }
            }
            System.out.println(!is ? "NO" : "YES");
        }

    }

    public static class TrieNode{

        TrieNode[] children = new TrieNode[10];

        boolean isEnd;
        TrieNode(){
            isEnd = false;

            for(int i = 0; i<10; i++){
                children[i] = null;
            }
        }
    }

    public static boolean Insert(String s){
        TrieNode t = root;
        for(int i = 0; i<s.length(); i++){
            int index = s.charAt(i) - '0';
            if(t.isEnd) return false;

            if(t.children[index] == null){
                t.children[index] = new TrieNode();
            }

            t = t.children[index];
        }

        for(int i = 0; i<10; i++){
            if(t.children[i] != null) return false;
        }
        t.isEnd = true;
        return true;

    }
}