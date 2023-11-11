package Programmers;

import java.util.*;
import java.util.stream.Collectors;

public class BiggestNum {

    public static void main(String[] args) {

        Solution s = new Solution();
        String solution = s.solution(new int[]{3, 30, 34, 5, 9});
        System.out.println(solution);
    }

    static class Solution {

        public String solution(int[] numbers) {
            String[] nums = new String[numbers.length];
            for(int i=0 ; i<numbers.length ; i++){
                nums[i] = String.valueOf(numbers[i]);
            }
            Arrays.sort(nums, (o1, o2) -> (o2+o1).compareTo(o1+o2));

            if(nums[0].equals("0")) return "0";

            StringBuilder sb = new StringBuilder();

            for(String n : nums){
                sb.append(n);
            }

            return sb.toString();
        }
    }
}
