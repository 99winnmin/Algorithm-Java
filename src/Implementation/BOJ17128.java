package Implementation;
import java.io.*;
import java.util.*;

public class BOJ17128 {
    static int N,Q;
    static int[] cows;
    static int[] scores;
    static int[] qList;

    public static void main(String[] args) throws Exception {
        init();
        solution();
        print();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().split(" ");
        N = Integer.parseInt(nq[0]);
        Q = Integer.parseInt(nq[1]);
        cows = new int[N+1];
        scores = new int[N+1];
        qList = new int[Q];

        String[] cowInputs = br.readLine().split(" ");
        for (int i=1 ; i<=N ; i++){
            cows[i] = Integer.parseInt(cowInputs[i-1]);
        }

        String[] qInputs = br.readLine().split(" ");
        for (int i=0 ; i<Q ; i++){
            qList[i] = Integer.parseInt(qInputs[i]);
        }
    }

    private static void print() {
        for (int i=0 ; i<qList.length ; i++) {
            System.out.println(qList[i]);
        }
    }

    private static void solution() {
        // init operation
        int initTotal = 0;
        for (int i=1 ; i<=N ; i++){
            scores[i] = 1;
            for (int j=i ; j<=i+3 ; j++) {
                if (j > N)
                    scores[i] *= cows[j-N];
                else
                    scores[i] *= cows[j];
            }
            initTotal += scores[i];
        }

        // q operation
        int qScores = 1;
        for (int i=0 ; i<Q ; i++) {
            int qIndex = qList[i];
            // 영향 받은 4군데 찾아서 합산 구해놓고 나중에 빼기
            int sNum = 0;
            for (int j=3 ; j>=0 ; j--) {
                if (qIndex - j <= 0)
                    sNum += scores[N + (qIndex - j)];
                else
                    sNum += scores[qIndex - j];
            }

            // 영향 주기
            cows[qIndex] = cows[qIndex] * -1;

            // 영향 받는 4군데 변환 합산 구해놓고 나중에 더하기
            int qNum = 0;
            for (int j=3 ; j>=0 ; j--) { // 4군데 스코어 다시 곱산
                int temp = 1;
                if (qIndex - j <= 0){
                    scores[N + (qIndex - j)] = 1;
                    for (int k=0 ; k<4 ; k++) {
                        if (N + (qIndex - j) + k > N)
                            temp *= cows[N + (qIndex - j) + k - N];
                        else
                            temp *= cows[N + (qIndex - j) + k];
                    }
                    scores[N + (qIndex - j)] = temp;
                }
                else {
                    for (int k=0 ; k<4 ; k++) {
                        if (qIndex - j + k > N)
                            temp *= cows[qIndex - j + k - N];
                        else
                            temp *= cows[qIndex - j + k];
                    }
                    scores[qIndex - j] = temp;
                }
                qNum += temp;
            }

            initTotal = initTotal - sNum + qNum;
            qList[i] = initTotal;
        }
    }
}
