package Implementation;

import java.util.*;

public class Boj2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int N = sc.nextInt();
        Double total = 0.0;
        for (int i=0 ; i<N ; i++){
            int num = sc.nextInt();
            list.add(num);
            total += num;
        }

        Collections.sort(list);
        int max = Collections.max(list);
        int min = Collections.min(list);

        System.out.println(Math.round(total / N));

        System.out.println(list.get(list.size()/2));

        // 최빈값 찾기
        HashMap<Integer, Integer> freqList = new HashMap<>();
        for (int num : list){
            freqList.put(num, freqList.getOrDefault(num, 0)+1);
        }

        int numbers = 0;
        for(int value : freqList.values()){ // 빈도수가 가장 큰 value 찾기
            numbers = Math.max(numbers, value);
        }

        list.clear();
        for (int key : freqList.keySet()){
            if (freqList.get(key) == numbers){
                list.add(key);
            }
        }

        Collections.sort(list);

        if (list.size() >= 2) {
            System.out.println(list.get(1));
        } else {
            System.out.println(list.get(0));
        }

        System.out.println(Math.abs(max-min));
    }
}
