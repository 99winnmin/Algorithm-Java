package Implementation;

import java.util.Scanner;
import java.util.Stack;

public class Boj10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalNum = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < totalNum; i++) {
            int num = sc.nextInt();
            if (num != 0) {
                stack.push(num);
            } else {
                stack.pop();
            }
        }

        System.out.println(stack.stream()
                .mapToInt(Integer::intValue)
                .sum());
    }
}
