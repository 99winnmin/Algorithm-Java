package Kakao.T2022;
import java.io.*;
import java.util.*;

public class Q1 {

    public static void main(String[] args) {

    }

    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('R', 0); map.put('T', 0);
        map.put('C', 0); map.put('F', 0);
        map.put('J', 0); map.put('M', 0);
        map.put('A', 0); map.put('N', 0);
        ArrayList<Character> search = new ArrayList<>();
        search.add('R'); search.add('T');
        search.add('C'); search.add('F');
        search.add('J'); search.add('M');
        search.add('A'); search.add('N');
        for(int i=0 ; i<survey.length ; i++){
            if (choices[i] == 4) continue;
            if (choices[i]/4 > 0) {
                int point = choices[i]%4;
                Character c = survey[i].charAt(1);
                System.out.println(c + " " + point);
                map.compute(c, (key, value) -> value + point);
            } else {
                int point = 4-choices[i];
                Character c = survey[i].charAt(0);
                System.out.println(c + " " + point);
                map.compute(c, (key, value) -> value + point);
            }
        }

        for(int i=0 ; i<8 ; i += 2){
            Character c1 = search.get(i);
            Character c2 =search.get(i+1);
            int point1 = map.get(c1);
            int point2 = map.get(c2);
            System.out.println(point1 + " " + point2);
            if (point1 >= point2) answer.append(c1);
            else answer.append(c2);
        }

        return answer.toString();
    }
}
