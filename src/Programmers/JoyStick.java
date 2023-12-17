package Programmers;

import java.util.*;

public class JoyStick {

    public static void main(String[] args) {
        //JEROEN
        System.out.println(26 - Math.abs("J".charAt(0) - "A".charAt(0)));
        System.out.println(Math.abs("J".charAt(0) - "A".charAt(0)));

        Solution s = new Solution();
    }

    static class Solution {
        public int solution(String name) {
            int answer = 0;
            for(int i=0 ; i<name.length() ; i++){
                char curr = name.charAt(i);
                int a = 26 - Math.abs(curr - "A".charAt(0));
                int b = Math.abs(curr - "A".charAt(0));
                answer += Math.min(a, b);

            }
            return answer;
        }
    }
}
