package softTeer.practice.level3;

import java.io.*;
import java.util.*;

public class Bridge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] bridge = new int[N];
        int[] count = new int[N];

        for(int i=0 ; i<N ; i++){
            bridge[i] = sc.nextInt();
        }

//        for(int i=0 ; i<N ; i++){
//            if (i == N-1) break;
//            if(bridge[i] < bridge[i+1]){
//                count[i+1] = count[i]+1;
//            }
//        }
        int ans = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (bridge[i] > bridge[j]) {
                    count[i] = Math.max(count[i], count[j]+1);
                }
            }
            ans = Math.max(ans, count[i]);
        }

//        int max = 0;
        for(int i=0 ; i<N ; i++){
            System.out.print(count[i] + " ");
//            if(count[i] > max) max = count[i];
        }
        System.out.println();
        System.out.println(ans+1);
    }
}
