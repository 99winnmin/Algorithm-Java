package DataStructure.Stack;

import java.io.*;
import java.util.*;

public class Boj3015R {
    // https://lotuslee.tistory.com/105
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Person> stack = new Stack<>();
        long count = 0;

        for (int i=0 ; i<N ; i++) {
            int h = Integer.parseInt(br.readLine());
            Person newP = new Person(h,1);

            while(!stack.isEmpty() && stack.peek().height <= h) {
                Person person = stack.pop();
                count += person.cnt;
                if (person.height == h) {
                    newP.cnt += person.cnt;
                }
            }

            if (!stack.isEmpty()) count++;
            stack.push(newP);
        }
        System.out.println(count);
    }

    private static class Person {
        int height;
        int cnt;

        public Person(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }
}
