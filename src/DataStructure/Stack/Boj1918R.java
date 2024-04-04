package DataStructure.Stack;

import java.io.*;
import java.util.*;

public class Boj1918R {
    private static char[] opSet = {'+', '-', '*', '/', '(', ')'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        char[] cal = br.readLine().toCharArray();

        for (char word : cal) {
            if (isOp(word)) {
                if (word == '(') {
                    stack.add(word);
                    continue;
                }
                if (word == ')') {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop(); // ( 없애기
                    continue;
                }
                while(!stack.isEmpty() && priority(word) <= priority(stack.peek())) {
                    sb.append(stack.pop());
                }

                stack.add(word);
            } else { // 변수일 경우
                sb.append(word);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    private static boolean isOp(char c) {
        for (char op : opSet) {
            if (c == op) return true;
        }
        return false;
    }

    private static int priority(char c) {
        if (c == '(' || c == ')') return -1;
        else if (c == '*' || c == '/') return 1;
        else return 0; // +,-
    }
}
