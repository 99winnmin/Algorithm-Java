package Programmers;

import java.util.*;

public class Cloth {

    public static void main(String[] args) {
        Solution s = new Solution();
    }

    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, ArrayList<Integer>> cMap = new HashMap<>();
            for(int i=0 ; i<clothes.length ; i++){
                cMap.computeIfAbsent(clothes[i][1], k->new ArrayList<>()).add(i);
            }
            for(ArrayList<Integer> list : cMap.values()){
                answer *= list.size()+1;
            }
            return answer-1; // 아무것도 안입는 경우는 빼기
        }
    }
}
