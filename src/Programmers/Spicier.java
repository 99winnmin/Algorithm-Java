package Programmers;
import java.util.*;

public class Spicier {

    public static void main(String[] args) {
        Solution s = new Solution();
        int solution = s.solution(new int[]{1,1,9,1,1,1}, 1);
        System.out.println(solution);
    }

    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0 ; i<scoville.length ; i++){
                pq.add(scoville[i]);
            }
            int min = pq.element();

            while(min < K){
                if(pq.size() == 1) return -1;
                answer++;
                int first = pq.poll();
                int second = pq.poll();
                int mix = first + second*2;
                pq.add(mix);
                min = pq.element();
            }

            return answer;
        }
    }
}
