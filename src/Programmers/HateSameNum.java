package Programmers;

import java.util.*;

public class HateSameNum {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] solution = s.solution(new int[]{});
        for(int i : solution){
            System.out.print(i + " ");
        }
    }

    static class Solution {
        public int[] solution(int []arr) {
            ArrayList<Integer> list = new ArrayList<>();
            // 쓸데없이 큐로 푸니까 시간 초과남
//            Queue<Integer> q = new LinkedList<>();
//            for(int i : arr) q.add(i);
//            while(!q.isEmpty()){
//                int num = q.poll();
//                if (list.isEmpty()){
//                    list.add(num);
//                    continue;
//                }
//                int lastNum = list.get(list.size()-1);
//                if(num != lastNum) list.add(num);
//            }
            for(int i=0 ; i<arr.length ; i++){
                if(i==0) {
                    list.add(arr[i]);
                    continue;
                }
                if(arr[i] != list.get(list.size()-1)) list.add(arr[i]);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
