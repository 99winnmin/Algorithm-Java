package softTeer.practice.level2;

import java.io.*;
import java.util.*;


public class MapMaking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = 1 + (2 * (int) Math.pow(2,N-1));
        int answer = (int)Math.pow(k, 2);
        System.out.println(answer);
    }

}
