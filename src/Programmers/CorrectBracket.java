package Programmers;

import java.util.*;

public class CorrectBracket {

    public static void main(String[] args) {

        Solution s = new Solution();
        boolean solution = s.solution(")())");
        System.out.println(solution);
    }

    static class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<Character>();
            for(int i=0 ; i<s.length() ; i++){
                if (s.charAt(i) == '(') {
                    stack.push('(');
                } else if(s.charAt(i) == ')') {
                    if (stack.isEmpty()) return false;
                    stack.pop();
                }
            }

            return stack.isEmpty();
        }
    }
}
