import java.util.Arrays;
import java.util.Scanner;

public class Greedy2
{
    public static void main(String[] args) {
        int N, M, K;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        int[] list = new int[N];
        for (int i = 0; i < list.length; i++)
        {
            list[i] = sc.nextInt();
        }
        Arrays.sort(list);
        int first = list[N-1];
        int second = list[N-2];
        int count = K * (M / (K+1)) + (M % (K+1));
        int answer = ( first * count )+ (second * (M / (K+1)) );
        System.out.println(answer);

    }
}
