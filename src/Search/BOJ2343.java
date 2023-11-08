package Search;

import java.io.*;
import java.util.*;


public class BOJ2343 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int start = 0;
        int end = 0;
        for(int i=0 ; i<N ; i++){
            A[i] = sc.nextInt();
            if(start < A[i]) start = A[i];
            end = end + A[i];
        }

        while(start <= end){
            int mid = (start+end) / 2;
            System.out.println("start : "+start+" || " + "end : " + end);
            int sum = 0;
            int count = 0;
            for(int i=0 ; i<N ; i++){
                if(sum + A[i] > mid){
                    count++;
                    sum=0;
                }
                sum = sum + A[i];
            }
            if(sum!=0) count++;
            System.out.println("sum: " + sum + " || mid : "+mid+" || " + "count : " + count);
            System.out.println();

            if (count > M) start = mid+1;
            else end = mid-1;
        }
        System.out.println(start);
    }
}
