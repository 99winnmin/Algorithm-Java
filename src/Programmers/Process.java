package Programmers;

import java.util.*;

public class Process {

    public static void main(String[] args) {
//        1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
//        2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
//        3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
//            3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
        Solution s = new Solution();
        int location = 0;
        int solution = s.solution(new int[]{1,1,9,1,1,1}, location);
        System.out.println(solution);
    }

    static class Solution {
        static PriorityQueue<Integer> maxP = new PriorityQueue<>(Collections.reverseOrder());
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<int[]> queue = new LinkedList<>();
            for(int i=0 ; i<priorities.length ; i++){
                maxP.add(priorities[i]);
                queue.add(new int[]{i, priorities[i]});
            }

            while(!queue.isEmpty()){
                int max = maxP.element();
                int[] process = queue.element();

                if (process[1] >= max){
                    answer++;
                    maxP.remove();
                    queue.remove();
                    if (process[0] == location) return answer;
                } else {
                    queue.remove();
                    queue.add(process);
                }
            }
            return answer;
        }
    }
}
