package Implementation;

public class Boj4673 {
    public static void main(String[] args) {
        boolean[] table = new boolean[10001];
        for (int i = 1; i < table.length; i++) {
            if (selfNumDecider(i) <= 10000)
                table[selfNumDecider(i)] = true;
        }

        for (int i = 1; i < table.length; i++) {
            if (!table[i])
                System.out.println(i);
        }
    }

    public static int selfNumDecider(int num) {
        int length = String.valueOf(num).length();
        switch (length) {
            case 1:
                return num * 2;
            case 2:
                return num + (num % 100 / 10) + (num % 10);
            case 3:
                return num + (num % 1000 / 100) + (num % 100 / 10) + (num % 10);
            case 4:
                return num + (num % 10000 / 1000) + (num % 1000 / 100) + (num % 100 / 10) + (num % 10);
            case 5:
                return num + (num % 100000 / 10000) + (num % 10000 / 1000) + (num % 1000 / 100) + (num % 100 / 10) + (num % 10);
            default:
                return 0;
        }
    }
}
