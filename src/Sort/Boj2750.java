package Sort;

import java.io.*;
import java.util.*;

public class Boj2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0 ; i<N ; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<N-i-1 ; j++) {
                int first = arr[j];
                int second = arr[j+1];
                if (first > second) {
                    arr[j+1] = first;
                    arr[j] = second;
                }
            }
        }
//        Arrays.sort(arr);
        for (int i=0 ; i<N ; i++) {
            System.out.println(arr[i]);
        }

    }
}
