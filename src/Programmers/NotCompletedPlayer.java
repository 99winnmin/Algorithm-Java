package Programmers;

import java.util.*;

public class NotCompletedPlayer {

    public static void main(String[] args) {

    }
}

class Solution3 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, ArrayList<Integer>> pList = new HashMap<>();

        for(int i=0 ; i<participant.length ; i++){
            pList.computeIfAbsent(participant[i], k->new ArrayList<>()).add(i);
        }
        for(String c : completion){
            if(pList.get(c).size() < 2){
                pList.remove(c);
            } else {
                pList.get(c).remove(0);
            }
        }
        for(String p : pList.keySet()){
            answer = p;
        }
        return answer;
    }
}