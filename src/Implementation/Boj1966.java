package Implementation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int N = sc.nextInt();
            int target = sc.nextInt();
            Queue<Integer> priorities = new LinkedList<>();
            Queue<Boolean> targetTable = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                int priority = sc.nextInt();
                if (target == j) {
                    targetTable.add(true);
                } else {
                    targetTable.add(false);
                }
                priorities.add(priority);
            }

            int cnt = 1;

            while (!targetTable.isEmpty()) {
                int max = priorities.stream().mapToInt(Integer::intValue).max().getAsInt();
                int first = priorities.poll().intValue();
                Boolean first2 = targetTable.poll();
                if (first == max && first2) {
                    break;
                } else if (first == max) {
                    cnt++;
                } else {
                    priorities.add(first);
                    targetTable.add(first2);
                }
            }
            System.out.println(cnt);
        }
    }
}
