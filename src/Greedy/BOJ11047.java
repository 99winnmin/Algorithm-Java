package Greedy;

import java.io.*;
import java.util.*;

public class BOJ11047 {
    // 목표 금액보다 작거나 같은 단위가 나오면 나누고 개수 추가하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> priceList = new ArrayList<>();

        for(int i=0 ; i<N ; i++){
            priceList.add(sc.nextInt());
        }
        priceList.sort(Collections.reverseOrder());

        int total = 0;
        for(int p : priceList){
            if (K == 0) break;
            if (p <= K) {
                total += K/p;
                K = K%p;
            }
        }
        System.out.println(total);
    }
}
