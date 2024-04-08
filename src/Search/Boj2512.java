package Search;

import java.io.*;
import java.util.*;

public class Boj2512 {
    private static int N,total,max;
    private static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        max = arr[N-1];
        st = new StringTokenizer(br.readLine());
        total = Integer.parseInt(st.nextToken());

        while(true) {
            int result = isPossible(0, N-1);
            if (result <= total) break;
            max--;
        }
        System.out.println(max);
    }

    private static int isPossible(int start, int end) {
        int sum = 0;
        int mid = (start+end)/2;

        if (start < end) {
            sum += isPossible(start, mid);
            sum += isPossible(mid+1, end);
        } else {
            if (arr[start] <= max) sum += arr[start];
            else sum += max;
        }
        return sum;
    }
}
