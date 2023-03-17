package Implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Boj2941 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("c=","c-","dz=","d-","lj","nj","s=","z=");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int answer = 0;
        while (str.length() != 0){
            int tempLength = str.length();
            for(String s : list){
                if (str.startsWith(s)){
                    answer++;
                    str = str.substring(str.indexOf(s)+s.length());
                    break;
                }
            }
            if (tempLength == str.length()){
                str = str.substring(1);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
