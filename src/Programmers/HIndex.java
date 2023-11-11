package Programmers;

import java.util.*;

public class HIndex {

    public static void main(String[] args) {

        Solution s = new Solution();
        int solution = s.solution(new int[]{3, 30, 34, 5, 9});
        System.out.println(solution);
    }

    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            ArrayList<Integer> nums = new ArrayList<>();
            for(int i : citations){
                nums.add(i);
            }
            nums.sort(Collections.reverseOrder());

            boolean isFirst = false;
            for(int i=0 ; i<nums.size() ; i++){
                for(int j=nums.get(i) ; j>=0 ; j--){
                    int h = j;
                    int uppderCount = (int) nums.stream().filter(n -> n>=h).count();
                    int downerCount = (int) nums.stream().filter(n -> n<=h).count();
                    if(uppderCount >= h && downerCount <= h) {
                        answer = h;
                        isFirst = true;
                        break;
                    }
                }
                if (isFirst) break;
            }


            return answer;
        }
    }
}
