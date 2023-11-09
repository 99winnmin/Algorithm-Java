package Greedy;
import java.io.*;
import java.util.*;

public class BOJ1715 {
    // 작은 수끼리 먼저 더하는 것이 최종 결과에 영향을 미친다.
    // 내림차순으로 정렬한 다음 각각 연산 -> 40 20 10 -> 40 30 -> 70
    // 우선순위 큐 활용
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0 ; i<N ; i++ ){
            pq.add(sc.nextInt());
        }
        int data1 = 0;
        int data2 = 0;
        int sum = 0;
        while(pq.size() != 1) {
            data1 = pq.remove();
            data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1 + data2);
        }
        System.out.println(sum);
    }
}
