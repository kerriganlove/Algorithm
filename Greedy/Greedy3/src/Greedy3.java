import java.util.Arrays;
import java.util.Scanner;

public class Greedy3
{
    public static void main(String[] args)
    {
        int N,M;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int [][]list = new int[N][M];
        int []answerList = new int[N];
        for (int i = 0; i < N*M; i++) {
            list[i / M][i % M] = sc.nextInt();
        }
        for (int k = 0; k < N; k++)
        {
            Arrays.sort(list[k]);
            answerList[k] = list[k][0];
        }
        Arrays.sort(answerList);
        System.out.println(Arrays.toString(answerList)+","+answerList[N-1]);
    }
}

