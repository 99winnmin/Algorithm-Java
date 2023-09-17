package DataStructure.Stack;

import java.util.*;

public class Boj1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = sc.nextInt();

        int start = 0;

        // 1부터 차례대로 들어가게됨, Stack 구조상 pop 되서 나올 맨 위에 값이 입력 값과 다르면 출력이 불가능함
        while(N -- > 0) {
            int value = sc.nextInt();

            if (value > start) {
                for(int i = start+1 ; i <= value ; i++){
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = value;
            }

            else if(stack.peek() != value) { // 맨 위에 있는 값이 입력 값과 일치하지 않으면 틀림
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);

    }
}
