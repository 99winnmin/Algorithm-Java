package DataStructure.ArrayAndList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10986 {
    public static void main(String[] args) throws IOException {
        /**
         * (A+B)%C == ((A%C)+(B%C))%C -> 특정 구간 수들의 나머지 연산을 더해 나미지 연산을 한 값과
         *          이 구간 합의 나머지 연산을 한 값은 동일하다.
         *          S[i] - S[j] == A[j+1] + ... + A[i]
         *          즉 S[i]%M == S[j]%M 이면 (S[i]-S[j])%M도 0 -> S[x]가 같은 것을 두 쌍씩 고르면 됨
         *          그러면 j+1 ~ i의 구간 합이 M으로 나눠 떨어짐
         */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] S = new long[N];
        long[] C = new long[M]; // %M 시키고 나오는 값 인덱싱
        long answer = 0;

        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        S[0] = Integer.parseInt(st2.nextToken());
        for (int i = 1; i < N; i++) { // 구간 합 배열 생성
            S[i] = S[i - 1] + Integer.parseInt(st2.nextToken());
        }
        for (int i = 0; i < N; i++) {
            if (S[i] % M == 0) answer++; // 연산의 나머지가 0이면 answer++
            C[(int) (S[i] % M)]++; // 나머지가 같은 것들 인덱싱
            S[i] = S[i] % M;
        }
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer += (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}
