package Programmers;

import java.util.*;

public class ChangeWord {

    public static void main(String[] args) {
        Solution s = new Solution();
        int solution = s.solution("hit", "cog",
            new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(solution);
    }

    static class Solution {
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            Map<String, Boolean> visited = new HashMap<>();
            visited.put(begin, false);
            for(String word : words){
                visited.computeIfAbsent(word, k -> false);
            }

            Queue<String> queue = new LinkedList<>();
            queue.add(begin);

            String curr = begin;
            while(!queue.isEmpty()){
                curr = queue.poll();
                visited.compute(curr, (k,v) -> true);
                if(curr.equals(target)) break;

                int addCount = 0;
                for(int i=0 ; i<words.length ; i++){
                    if (canChange(curr, words[i]) && !visited.get(words[i])) {
                        queue.add(words[i]);
                        visited.compute(words[i], (k,v) -> true);
                        addCount++;
                    }
                }
                if (addCount > 0) answer++;
                else answer--;
            }
            if(!curr.equals(target)) return 0;
            return answer;
        }

        public boolean canChange(String str1, String str2){
            int diffCount = 0;
            for(int i=0 ; i<str2.length() ; i++){
                if (str1.charAt(i) != str2.charAt(i)) diffCount++;
            }
            return diffCount == 1;
        }
    }
}
