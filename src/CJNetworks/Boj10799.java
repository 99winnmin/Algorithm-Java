package CJNetworks;

import java.io.*;
import java.util.*;

public class Boj10799 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i=0 ; i<input.length ; i++) {
            if (input[i] == '(') {
                stack.add(input[i]);
                // raiser
                if (input[i+1] == ')') {
                    stack.pop();
                    answer += stack.size();
                    i++;
                }
            } else {
                answer++;
                stack.pop();
            }
        }
        System.out.println(answer);
    }
}
