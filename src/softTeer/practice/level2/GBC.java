package softTeer.practice.level2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GBC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] limit = new int[101];
        int[] test = new int[101];
        int now = 1;
        for(int i=0 ; i<N ; i++){
            int length = sc.nextInt();
            int speed = sc.nextInt();
            for(int j=now ; j<now+length ; j++){
                limit[j] = speed;
            }
            now = now+length;
        }

        now = 1;
        for(int i=0 ; i<M ; i++){
            int length = sc.nextInt();
            int speed = sc.nextInt();
            for(int j=now ; j<now+length ; j++){
                test[j] = speed;
            }
            now = now+length;
        }

        for(int i=1 ; i<101 ; i++) test[i] = test[i]-limit[i];

        ArrayList<Integer> list = new ArrayList<>();
        for(int i : test){
            list.add(i);
        }
        list.sort(Collections.reverseOrder());
        System.out.println(list.get(0));
    }
}
