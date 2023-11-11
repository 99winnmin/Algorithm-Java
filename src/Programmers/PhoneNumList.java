package Programmers;

import java.util.*;

public class PhoneNumList {

    public static void main(String[] args) {
        Solution s = new Solution();
    }

    static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            HashMap<String, Integer> mp = new HashMap<>();
            for(int i=0 ; i<phone_book.length ; i++){
                mp.putIfAbsent(phone_book[i], i);
            }

            for(int i=0 ; i<phone_book.length ; i++){
                for(int j=0 ; j<phone_book[i].length() ; j++){
                    if (mp.containsKey(phone_book[i].substring(0,j))) return false;
                }
            }
            return answer;
        }
    }
}
