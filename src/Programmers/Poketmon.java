package Programmers;
import java.util.*;

public class Poketmon {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = new int[]{3,3,3,2,2,4,5};
        int solution = s.solution(num);
        System.out.println(solution);
    }

    static class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
            for(int i=0 ; i<nums.length ; i++){
                hm.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
            }
            // N/2 마리 고를 때 폰켓몬 종류 수의 최댓값
            // 3 1 2 3
            return hm.keySet().size() > nums.length/2 ? nums.length/2 : hm.keySet().size();
        }
    }
}
