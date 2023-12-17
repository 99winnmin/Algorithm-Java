package Implementation;

import java.io.*;
import java.util.*;

public class BOJ1244 {
    static int num, student;
    static int[] switchStatus;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        switchStatus = new int[num+1];
        String[] states = br.readLine().split(" ");
        for(int i=0 ; i<num ; i++){
            switchStatus[i+1] = Integer.parseInt(states[i]);
        }

        student = Integer.parseInt(br.readLine());
        for(int i=0 ; i<student ; i++){
            String[] command = br.readLine().split(" ");
            if (command[0].equals("1")) {
                boy(Integer.parseInt(command[1]));
            } else if (command[0].equals("2")) {
                girl(Integer.parseInt(command[1]));
            } else {
                return;
            }
        }

        printAnswer();
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=1 ; i<=num ; i++) {
            sb.append(switchStatus[i]).append(" ");
            count++;
            if (count%20 == 0) {
                System.out.println(sb);
                sb = new StringBuilder();
            }
        }
        System.out.println(sb);
    }

    private static void boy(int n) {
        for (int b=1 ; b<=num ; b++){
            if (b%n == 0){
                switchStatus[b] = switchStatus[b] == 1 ? 0 : 1;
            }
        }
    }

    private static void girl(int n) {
        for(int g=0 ; g<num/2 + 1 ; g++){
            if (n-g <= 0 || n+g > num) return;
            if (g != 0){
                if (switchStatus[n-g] == switchStatus[n+g]) {
                    switchStatus[n-g] = switchStatus[n-g] == 1 ? 0 : 1;
                    switchStatus[n+g] = switchStatus[n+g] == 1 ? 0 : 1;
                } else {
                    return;
                }
            } else {
                switchStatus[n] = switchStatus[n] == 1 ? 0 : 1;
            }
        }
    }
}
