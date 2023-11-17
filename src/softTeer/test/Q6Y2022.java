package softTeer.test;

import java.io.*;
import java.util.*;

public class Q6Y2022 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strSeat = br.readLine().split(" ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(String num : strSeat){
            pq.add(Integer.parseInt(num));
        }

        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while(!pq.isEmpty()){
            int u = pq.poll();
            if (pq.isEmpty()) break;
            int v = pq.element();
            if(v-u < min) {
                min = v-u;
                answer[0] = u;
                answer[1] = v;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }


}
