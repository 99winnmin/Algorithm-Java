package Search;

import java.io.*;
import java.util.*;

public class BOJ2023 {
    static int N;
//    static boolean[] sosu;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

//        calSosu((int) Math.pow(10.0, N)-1);

        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

//    // 에라토스테네스의 채 알고리즘 적용 -> 사용하면 메모리 초과
//    public static void calSosu(int maxNum) {
//        sosu = new boolean[maxNum+1];
//        Arrays.fill(sosu, true); // boolean배열의 default값은 false이므로 true로 바꿔주기
//
//        sosu[0] = sosu[1] = false;
//
//        for (int i=2 ; i <= Math.sqrt(maxNum) ; i++) { // 2부터 n의 제곱근까지의 모든 수를 확인
//            if (sosu[i]) { // 해당수가 소수라면, 해당수를 제외한 배수들을 모두 false 처리하기
//                for (int j=i*i ; j < maxNum ; j+=i) { // 그 이하의 수는 모두 검사했으므로 i*i부터 시작
//                    sosu[j] = false;
//                }
//            }
//        }
//    }

    public static boolean isSosu(int num) {
        for (int i=2 ; i<num/2 ; i++ ){
            if (num%i == 0) return false;
        }
        return true;
    }

    public static void DFS(int num, int jarisu) {
        if (jarisu == N) {
            if (isSosu(num)) System.out.println(num);
            return;
        }

        for (int i=1 ; i<10 ; i++ ) {
            if (i%2==0) continue;
            if (isSosu(num*10+i)) DFS(num*10+i, jarisu+1);
        }
    }

}
