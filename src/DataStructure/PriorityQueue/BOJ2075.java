package DataStructure.PriorityQueue;
import java.io.*;
import java.util.*;

public class BOJ2075 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0 ; i<N*N ; i++) pq.add(sc.nextInt());
        for (int i=1 ; i<N ; i++) pq.poll();
        System.out.println(pq.poll());
    }
}
