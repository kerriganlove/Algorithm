import java.util.Scanner;

public class Greedy4
{
    public static void main(String[] args)
    {
        int N,M;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        while ( N != 1) {
            if (N % M == 0)
            {
                N = N / M;
                count++;
            }
            else {
                N = N-1;
                count++;
            }
        }
        System.out.println(count);
    }
}
