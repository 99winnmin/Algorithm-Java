package Implementation;
import java.io.*;
import java.util.*;

public class BOJ9081 {
    static int T;
    static Map<Character, Integer> alphTable = new LinkedHashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i=0 ; i<T ; i++) {
            for (Character c = 'A' ; c <= 'Z' ; c++) alphTable.put(c, 0);
            String word = br.readLine();
            Character c = null;
            boolean noAnswer = true;
            for (int j=word.length()-1 ; j>=0 ; j--){
                alphTable.computeIfPresent(word.charAt(j), (k,v) -> v = v+1);
                if (j == word.length()-1) continue;

                if (word.charAt(j) < word.charAt(j+1)) {
                    noAnswer = false;
                    String post = word.substring(0, j);
                    System.out.print(post);
                    c = word.charAt(j);
                    break;
                }
            }
            if (noAnswer){
                System.out.println(word);
            } else {
                Character nextChar = printTarget(c);
                printCharsByAlphabetOrder(nextChar);
                System.out.println();
            }
        }
    }

    static Character printTarget(Character c) {
        boolean targetSearch = false;
        Map<Character, Integer> sortedMap = new TreeMap<>(alphTable);

        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            char character = entry.getKey();
            int frequency = entry.getValue();
            if (c == character) {
                targetSearch = true;
                continue;
            }
            for (int i = 0; i < frequency; i++) {
                if (targetSearch) {
                    System.out.print(character);
                    return character;
                }
            }
        }
        return null;
    }

    static void printCharsByAlphabetOrder(Character c) {
        Map<Character, Integer> sortedMap = new TreeMap<>(alphTable);

        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            char character = entry.getKey();
            int frequency = entry.getValue();
            if (character == c) continue;
            for (int i = 0; i < frequency; i++) {
                System.out.print(character);
            }
        }
    }
}
