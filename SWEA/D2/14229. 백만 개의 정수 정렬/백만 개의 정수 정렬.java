import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] arr;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        arr = new int[1000000];
        tmp = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, 999999);

        System.out.println(arr[500000]);
    }

    static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                tmp[idx] = arr[l];
                idx++;
                l++;
            } else {
                tmp[idx] = arr[r];
                idx++;
                r++;
            }
        }
        if (l <= mid) {
            for (int i = l; i <= mid; i++) {
                tmp[idx++] = arr[i];
            }
        } else {
            for (int i = r; i <= right; i++) {
                tmp[idx++] = arr[i];
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
}