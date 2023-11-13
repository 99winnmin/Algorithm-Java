package Programmers;

import java.util.*;

public class FuncDev {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] solution = s.solution(new int[]{90,90}, new int[]{10,9});
        for(int i : solution){
            System.out.print(i + " ");
        }
    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            if(progresses.length == 0) return new int[0];

            Queue<Integer> q = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0 ; i<progresses.length ; i++){
                int day = (int) Math.ceil((double)(100-progresses[i])/speeds[i]);
                q.add(day);
            }

            while(!q.isEmpty()){
                int count = 1;
                int curr = q.poll();
                while(!q.isEmpty()){
                    int next = q.element();
                    if(curr < next) break;
                    q.remove();
                    count++;
                }
                list.add(count);
            }

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
