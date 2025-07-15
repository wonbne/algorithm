import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i = 0; i < k; i++){
            set.add(br.readLine());
        }

        String[] s = set.toArray(new String[0]);

        for(int i = 0; i < s.length-1; i++) {
            for (int t = i + 1; t < s.length; t++) {
                if (s[i].length() > s[t].length() || (s[i].length() == s[t].length() && s[i].compareTo(s[t]) > 0)) {
                    String temp = s[i];
                    s[i] = s[t];
                    s[t] = temp;
                }
            }
        }

        for(int i = 0; i < s.length; i++){
            System.out.println(s[i]);
        }
    }
}
