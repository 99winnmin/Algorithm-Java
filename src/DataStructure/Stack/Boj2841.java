package DataStructure.Stack;

import java.io.*;
import java.util.*;

public class Boj2841 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Stack<Integer>[] lines = new Stack[N];
        int count = 0;
        for (int i=0 ; i<N ; i++) lines[i] = new Stack<>();

        for (int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            Stack<Integer> lStack = lines[line];
            if (lStack.isEmpty()) {
                count++;
                lStack.add(p);
            } else {
                while (!lStack.isEmpty() && p < lStack.peek()) {
                    lStack.pop();
                    count++;
                }
                if (!lStack.isEmpty() && lStack.peek() == p) continue;
                lStack.add(p);
                count++;
            }
        }
        System.out.println(count);
    }
}
