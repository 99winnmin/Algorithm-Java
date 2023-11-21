package Kakao.T2023;
import java.io.*;
import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        int[] pp = solution("2020.01.01", new String[]{"A 1"}, new String[]{"2019.12.01 A"});
//        solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
        for(int p : pp){
            System.out.println(p);
        }
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Privacy> pList = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        for(int i=0 ; i<terms.length ; i++){
            String[] t = terms[i].split(" ");
            termMap.computeIfAbsent(t[0], k-> Integer.parseInt(t[1]));
        }
        for(int i=0 ; i<privacies.length ; i++){
            String[] pr = privacies[i].split(" ");
            String[] date = pr[0].split("\\.");
            pList.add(new Privacy(
                Integer.parseInt(date[0]),
                Integer.parseInt(date[1]),
                Integer.parseInt(date[2]),
                termMap.get(pr[1])));
        }

        for(int i=0 ; i<pList.size() ; i++){
            System.out.println(pList.get(i).year + " " + pList.get(i).month + " " + pList.get(i).day);
            if(pList.get(i).isDiscard(today)) answer.add(i+1);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Privacy {
        Integer year;
        Integer month;
        Integer day;
        public Privacy(int year, int month, int day, int term){
            int[] date = addTerm(year, month, day, term);
            this.year = date[0];
            this.month = date[1];
            this.day = date[2];
        }

        public boolean isDiscard(String now){
            String[] ymd = now.split("\\.");
            if(this.year < Integer.parseInt(ymd[0])) return true;
            if(this.year == Integer.parseInt(ymd[0]) && this.month < Integer.parseInt(ymd[1])) return true;
            if(this.year == Integer.parseInt(ymd[0]) && this.month == Integer.parseInt(ymd[1]) && this.day < Integer.parseInt(ymd[2])) return true;
            return false;
        }

        private int[] addTerm(int year, int month, int day, int term) {
            int[] date = new int[3];
            // 년
            date[0] = year;
            // 월
            if(month+term > 12){
                date[0] += term/12;
                if (month + term%12 > 12){
                    date[0] += (month + term%12)/12;
                    date[1] = (month + term%12)%12;
                } else {
                    date[1] = month + term%12;
                }
            } else {
                date[1] = month+term;
            }
            // 일
            if (day == 1){
                date[2] = 28;
                if (date[1] == 1) {
                    date[0]--;
                    date[1] = 12;
                } else {
                    date[1]--;
                }
            } else {
                date[2] = day-1;
            }
            return date;
        }
    }
}
