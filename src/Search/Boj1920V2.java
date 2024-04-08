package Search;

import java.io.*;
import java.util.*;

public class Boj1920V2 {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr =  new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<M ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isExist(num)) System.out.println("1");
            else System.out.println("0");
        }
    }

    private static boolean isExist(int num) {
        int start = 0;
        int end = N-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (num == arr[mid]) {
                return true;
            } else if (num < arr[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
