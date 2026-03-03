import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			int N = Integer.parseInt(br.readLine().trim());
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			boolean isPermutation = true;
			int num = 1;
			for (int i = 0; i < N; i++) {
				if (arr[i] != num) {
					isPermutation = false;
					break;
				}
				
				num++;
			}
			
			
			sb.append(isPermutation ? "Yes" : "No").append("\n");
		}
		
		System.out.print(sb);
	}
}