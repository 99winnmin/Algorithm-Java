package Programmers;

import java.util.*;

public class DoublePQ {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] solution = s.solution(
            new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1",
                "I 333"});
        for(int i : solution){
            System.out.println(i);
        }
    }

    static class Solution {
        public int[] solution(String[] operations) {
            int dMinus1Count = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int i=0 ; i<operations.length ; i++){
                if(operations[i].startsWith("I")) {
                    pq.add(Integer.parseInt(operations[i].split(" ")[1]));
                    continue;
                }
                // 빈 큐일 때 연산 고려하기
                if(operations[i].equals("D 1")){
                    if(!pq.isEmpty()) pq.remove();
                } else {
                    if (!pq.isEmpty()) dMinus1Count++;
                }
            }

            if (pq.size() <= dMinus1Count) return new int[]{0,0};

            PriorityQueue<Integer> pq2 = new PriorityQueue<>();
            while(!pq.isEmpty()){
                pq2.add(pq.poll());
            }

            for(int i=0 ; i<dMinus1Count ; i++) pq2.poll();

            int max = 0;
            int min = pq2.poll();
            while(!pq2.isEmpty()){
                int n = pq2.poll();
                if(pq2.isEmpty()) max = n;
            }

            return new int[]{max, min};
        }
    }
}
