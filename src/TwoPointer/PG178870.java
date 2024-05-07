package TwoPointer;
import java.util.*;

public class PG178870 {
//    https://school.programmers.co.kr/learn/courses/30/lessons/178870
    static class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = {-1000001, 1000001};

            int s = 0;
            int e = 0;
            int sum = sequence[0];

            while(s < sequence.length && e < sequence.length) {
                if (sum == k) {
                    int preInterval = answer[1] - answer[0];
                    int nowInterval = e - s;
                    if (nowInterval < preInterval) answer = new int[]{s, e};
                    sum -= sequence[s];
                    s += 1;
                } else if (sum < k) {
                    e += 1;
                    if (e >= sequence.length) break;
                    sum += sequence[e];
                } else { // sum > k
                    sum -= sequence[s];
                    s += 1;

                }
            }

            return answer;
        }
    }
}
