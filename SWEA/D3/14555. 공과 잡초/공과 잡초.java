import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    if (i + 1 < s.length() && s.charAt(i + 1) == '|' || s.charAt(i + 1) == ')') {
                        count++;
                        i++;
                    }
                } else if (s.charAt(i) == ')') {
                    if (i - 1 >= 0 && s.charAt(i - 1) == '|') {
                        count++;
                    }
                }
            }
            sb.append("#" + tc + " " + count);
            System.out.println(sb);
        }
    }
}