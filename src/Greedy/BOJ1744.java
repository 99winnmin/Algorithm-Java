package Greedy;
import java.util.*;

public class BOJ1744 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0 ; i<N ; i++){
            int num = sc.nextInt();
            if (num <= 0) pq1.add(num);
            else pq2.add(num);
        }

        int total = 0;
        while(!pq1.isEmpty()){
            int curr = pq1.poll();
            if(pq1.size() == 0) {
                total += curr;
                break;
            }
            int next = pq1.poll();
            if (next == 0) {
                total += curr*next;
                continue;
            }
            total += curr*next;

        }

        while(!pq2.isEmpty()){
            int curr = pq2.poll();
            if(pq2.size() == 0) {
                total += curr;
                break;
            }
            int next = pq2.element();
            if (next == 1) {
                total += curr;
                continue;
            }
            next = pq2.poll();
            total += curr*next;
        }

        System.out.println(total);
    }

}
