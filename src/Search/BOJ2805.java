package Search;

import java.util.Scanner;

public class BOJ2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] trees = new int[N];
        int MAX = 0;
        for(int i=0 ; i<N ; i++){
            trees[i] = sc.nextInt();
            if(trees[i] > MAX) {
                MAX = trees[i];
            }
        }
        sc.close();

        int start = 0;
        int end = MAX;
        int result = 0;
        while(start <= end){
            int mid = (start+end)/2;
            int cutResult = 0;
            for (int tree : trees){
                if(tree > mid)
                    cutResult += (tree-mid);
            }
            if(M <= cutResult) {
                start = mid+1;
                if(mid >= result) {
                    result = mid;
                }
            } else {
                end = mid-1;
            }
        }

        System.out.println(result);

    }
}
