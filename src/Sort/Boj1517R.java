package Sort;

import java.io.*;
import java.util.*;

public class Boj1517R {
    private static long swap = 0;
    private static int[] arr, sort;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sort = new int[N];

        String[] inputs = br.readLine().split(" ");
        for (int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        mergeSort(0, N-1);
        System.out.println(swap);
    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start+end)/2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, end);
        }
    }

    private static void merge(int start, int end) {
        int mid = (start+end)/2;
        int idx1 = start;
        int idx2 = mid+1;
        int target = start;

        // sort 할때 뒤에 있는게 앞으로 갈 경우 swap count 더하기
        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) {
                sort[target++] = arr[idx1++];
            } else {
                sort[target++] = arr[idx2++];
                swap += mid + 1 - idx1;
            }
        }

        // 나머지 기록
        while (idx1 <= mid) {
            sort[target++] = arr[idx1++];
        }
        while (idx2 <= end) {
            sort[target++] = arr[idx2++];
        }

        // 원본에 sort 된거 반영
        for (int k=start ; k<=end ; k++) {
            arr[k] = sort[k];
        }
    }
}
