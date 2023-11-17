package softTeer.practice.level2;

import java.util.*;
import java.io.*;

public class Safecracking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int N = sc.nextInt();
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                if (a[1] != b[1]){
                    return Integer.compare(b[1], a[1]);
                } else {
                    return Integer.compare(b[0], a[0]);
                }
            }
        });
        for(int i=0 ; i<N ; i++){
            int limit = sc.nextInt();
            int price = sc.nextInt();
            pq.add(new int[]{limit, price});
        }

        int currW = 0;
        while(!pq.isEmpty()){
            int[] stone = pq.poll();
            if (currW + stone[0] <= W){
                currW += stone[0];
                answer += stone[0] * stone[1];
            } else {
                answer += (W-currW) * stone[1];
                break;
            }
        }

        System.out.println(answer);
    }
}
