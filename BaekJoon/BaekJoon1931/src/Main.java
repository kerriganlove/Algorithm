import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int count = 1;
        int minTime = 0;
        Integer[][] times = new Integer[N][2];
        for (int i = 0; i < N; i++) {
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
        }
        Arrays.sort(times, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(times, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1] - o2[1];
            }
        });
        minTime = times[0][1];
        for ( int i = 1; i < N; i++)
        {
            if (times[i][0] >= minTime)
            {
                minTime = times[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}