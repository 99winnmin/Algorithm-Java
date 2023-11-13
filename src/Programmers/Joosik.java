package Programmers;

import java.util.*;

public class Joosik {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(new int[]{1,1,9,1,1,1});
        System.out.println(solution);
    }

    static class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            for(int i=0 ; i<prices.length ; i++){
                for(int j=i+1 ; j<prices.length ; j++){
                    if (prices[i] > prices[j]) {
                        answer[i] += 1;
                        break;
                    }
                    else if (prices[i] <= prices[j]) {
                        answer[i] += 1;
                    }
                }
            }
            return answer;
        }
    }
}
