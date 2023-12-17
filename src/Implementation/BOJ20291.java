package Implementation;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ20291 {
    static int num;
    static Map<String, Integer> result = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        for (int i=0 ; i<num ; i++){
            String[] file = br.readLine().split("\\.");
            if (result.containsKey(file[1])) {
                result.compute(file[1], (k,v) -> v = v+1);
            } else {
                result.put(file[1], 1);
            }
        }

        List<String> resultSort = result.keySet().stream().collect(Collectors.toList());
        Collections.sort(resultSort);
        resultSort.stream()
            .forEach(key -> System.out.println(key + " " + result.get(key)));
    }
}
