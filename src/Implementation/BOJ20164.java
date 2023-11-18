package Implementation;
import java.util.*;
import java.io.*;
public class BOJ20164 {
    static int N,min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        init();
        solution();
        print();
    }

    private static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
    }

    private static void print(){
        System.out.print(min + " " + max);
    }

    private static void solution(){
        divideNum(N, 0);
    }

    private static void divideNum(int n, int count){
        count += countOddNum(n);

        if(n < 10){ // 숫자가 1자리 일때
            min = Math.min(min, count);
            max = Math.max(max, count);
            return;
        } else if(n < 100){ // 숫자가 2자리 일때
            int newNum = (n/10) + (n%10);
            divideNum(newNum, count);
        } else { // 숫자가 3자리 수 이상일 때
            String nums = String.valueOf(n);
            for(int i=1 ; i<nums.length()-1 ; i++){
                for(int j=i+1 ; j<nums.length() ; j++){
                    String one = nums.substring(0,i);
                    String two = nums.substring(i,j);
                    String three = nums.substring(j);
                    int newNum = Integer.parseInt(one) + Integer.parseInt(two) + Integer.parseInt(three);
                    divideNum(newNum, count);
                }
            }
        }
    }

    private static boolean isOddNum(int num){
        return num%2 == 1;
    }

    private static int countOddNum(int num){
        String[] nums = String.valueOf(num).split("");
        int count = 0;
        for(int i=0 ; i<nums.length ; i++){
            if (isOddNum(Integer.parseInt(nums[i]))) count++;
        }
        return count;
    }
}
