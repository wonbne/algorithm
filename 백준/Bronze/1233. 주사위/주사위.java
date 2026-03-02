import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int s1 = Integer.parseInt(st.nextToken());
		int s2 = Integer.parseInt(st.nextToken());
		int s3 = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> map = new HashMap<>();
		int maxCount = 0;
		int min = Integer.MAX_VALUE;
		for(int i =1; i<=s1; i++) {
			for(int j = 1; j<=s2; j++) {
				for(int k = 1; k<=s3; k++) {
					int sum = i + j+ k;
					if(map.containsKey(sum)) {
						map.put(sum, map.get(sum)+1);
						maxCount = Math.max(maxCount, map.get(sum));
					} else {
						map.put(sum,1);
					}
				}
			}
		}
		for(int key : map.keySet()) {
			if(map.get(key) == maxCount) {
				min = Math.min(min, key);
			}
		}
		System.out.println(min);
	}

}