package Kakao.T2022;
import java.util.*;

public class Q2 {

    public static void main(String[] args) {

    }

    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for(int i=0 ; i<queue1.length ; i++){
            q1.add((long) queue1[i]);
            q2.add((long) queue2[i]);
        }

        long total1 = q1.stream().mapToLong(Long::longValue).sum();
        long total2 = q2.stream().mapToLong(Long::longValue).sum();

        int count = 0;
        while(true){
            if(total1 == total2) break;
            // count > 4*queue1.length 조건 눈여겨 보기!!!
            // 최악의 경우 초기상태가 되었으면 절대 안되는 것
            // 1,2 를 다 빼고 다시 다 넣을 때 4*queue1.length 가 됌
            if(q1.isEmpty() || q2.isEmpty() || count > 4*queue1.length) return -1;
            count++;
            if (total1 > total2){
                long a = q1.poll();
                q2.add(a);
                total1 -= a;
                total2 += a;
            } else {
                long a = q2.poll();
                q1.add(a);
                total1 += a;
                total2 -= a;
            }
        }
        return count;
    }
}
