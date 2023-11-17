package softTeer.practice.level2;

import java.io.*;
import java.util.*;

public class Virus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int virus, rate, n;
        virus = scanner.nextInt();
        rate = scanner.nextInt();
        n = scanner.nextInt();

        int result = (int) ((long) virus * modPow(rate, n, 1000000007) % 1000000007);

        System.out.println(result);
    }

    // 모듈러 거듭제곱 연산을 구현하는 메서드
    private static int modPow(int base, int exponent, int mod) {
        long result = 1;
        long x = base;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * x) % mod;
            }
            x = (x * x) % mod;
            exponent /= 2;
        }

        return (int) result;
    }
}
