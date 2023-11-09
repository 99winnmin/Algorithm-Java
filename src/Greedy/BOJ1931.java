package Greedy;

import java.io.*;
import java.util.*;

public class BOJ1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][2];
        for(int i=0 ; i<N ; i++){
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E){
                if (S[1] == E[1]) { // 종료 시간이 같을 때 시작 시간이 빠른게 앞으로 옴
                    return S[0] - E[0];
                } else {
                    return S[1] - E[1];
                }
            }
        });

        // 회의 종료 시간이 빠를 수록 다음 회의와 겹치지 않게 시작하는데 유리함
        int count = 0;
        int end = 0;
        for(int i=0 ; i<N ; i++){
            if(A[i][0] >= end){ // 겹치지 않는 다음 회의가 나온 경우
                end = A[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
