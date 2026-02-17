import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String s = br.readLine();
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < n / 4; i++) {
				int idx = 0;
				while (idx < 4) {
					String sub = s.substring(idx * n / 4, idx * n / 4 + (n / 4));
					idx++;
					set.add(Integer.parseInt(sub,16));
				}
				s = s.charAt(n-1) + s.substring(0,n-1);
			}
			
			List<Integer> list = new LinkedList<>(set);
			Collections.sort(list, Collections.reverseOrder());
			System.out.println("#"+tc+" "+list.get(k-1));
		}
	}
}