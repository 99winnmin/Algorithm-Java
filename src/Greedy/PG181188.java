package Greedy;
import java.util.*;

public class PG181188 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/181188
    static class Solution {
        public int solution(int[][] targets) {
            int answer = 0;

            // e 기준으로 오름차순 정렬
            Arrays.sort(targets, (o1,o2) -> {return o1[1] - o2[1];});

            int last = -1;
            // 가장 마지막 구간이 현 구간에 포함되면 넘어감
            for(int[] bomb : targets) {
                if (last == -1){
                    answer++;
                    last = bomb[1] - 1;
                    continue;
                }

                if(bomb[0] <= last && last <= bomb[1]) continue;

                answer++;
                last = bomb[1]-1;
            }
            return answer;
        }
    }
}
