package Kakao.WinterIntern2023;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Q1 {
    public static void main(String[] args) {

    }
    static Map<String, Map<String, Integer>> giftHistory = new LinkedHashMap<>();
    static Map<String, Integer> giftPoint = new LinkedHashMap<>();
    static Map<String, Integer> result = new LinkedHashMap<>();
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        for (int i=0 ; i<friends.length ; i++) {
            giftHistory.computeIfAbsent(friends[i], p -> new HashMap<>());
            giftPoint.computeIfAbsent(friends[i], p -> 0);
            result.computeIfAbsent(friends[i], p -> 0);
        }
        for (int i=0 ; i<gifts.length ; i++) {
            String[] gift = gifts[i].split(" ");
            String giver = gift[0];
            String taker = gift[1];
            if (giftHistory.get(giver).containsKey(taker)){
                giftHistory.get(giver).compute(taker, (k,p) -> p = p+1);
            } else {
                giftHistory.get(giver).put(taker, 1);
            }
            giftPoint.compute(giver, (k,v) -> v = v+1);
            giftPoint.compute(taker, (k,v) -> v = v-1);
        }

        // 내가 줘야하는지만 체크하기!
        for (int i=0 ; i<friends.length ; i++) {
            for (int j=0 ; j<friends.length ; j++) {
                if (friends[i].equals(friends[j])) continue;
                // 선물 준적이 없음
                if (!giftHistory.get(friends[i]).containsKey(friends[j])){
                    // 받은적 있는지 체크
                    if (giftHistory.get(friends[j]).containsKey(friends[i])){
                        // 선물 무조건 줘야함
                        result.compute(friends[j], (k,v) -> v = v+1);
                    } else { // 없으면 선물 지수 체크, 내가 더 작은지만 체크
                        int myP = giftPoint.get(friends[i]);
                        int opP = giftPoint.get(friends[j]);
                        if (myP < opP) result.compute(friends[j], (k,v) -> v = v+1);
                    }
                } else { // 선물 준적 있음
                    // 받은게 있음
                    if (giftHistory.get(friends[j]).containsKey(friends[i])){
                        // 서로 주고 받은거 숫자 체크해서 줘야하는지 체크
                        int myCount = giftHistory.get(friends[i]).get(friends[j]);
                        int opCount = giftHistory.get(friends[j]).get(friends[i]);
                        if (myCount < opCount) {
                            result.compute(friends[j], (k,v) -> v = v+1);
                        } else if (myCount == opCount){
                            int myP = giftPoint.get(friends[i]);
                            int opP = giftPoint.get(friends[j]);
                            if (myP < opP) result.compute(friends[j], (k,v) -> v = v+1);
                        }
                    } // 받은적 없으면 안줘도됌
                }
            }
        }

        System.out.println(result.values().stream().mapToInt(Integer::intValue).max());

        return result.values().stream().mapToInt(Integer::intValue).max().getAsInt();
    }
}
