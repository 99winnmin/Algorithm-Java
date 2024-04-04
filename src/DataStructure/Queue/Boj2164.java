package DataStructure.Queue;

import java.util.*;

public class Boj2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0 ; i<N ; i++) {
            queue.add(i+1);
        }

        while(true) {
            if (queue.size() == 1) {
                System.out.println(queue.poll());
                break;
            }
            queue.poll();
            queue.add(queue.poll());
        }
    }
}
