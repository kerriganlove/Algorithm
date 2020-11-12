import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ChangeTwoArray
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N,K,temp;
        int sum = 0;
        N = sc.nextInt();
        K = sc.nextInt();
        Integer []A = new Integer[N];
        Integer []B = new Integer[N];
        for (int i = 0; i < N; i++)
        {
            A[i] = sc.nextInt();
        }
        for ( int j = 0; j < N; j++)
        {
            B[j] = sc.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        for ( int k = 0; k < K; k++)
        {
            if (A[k] < B[k]) { temp = A[k]; A[k] = B[k]; B[k] = temp; }
        }
        for (int i : A)
        {
            sum += i;
        }
        System.out.println(sum);
    }
}
