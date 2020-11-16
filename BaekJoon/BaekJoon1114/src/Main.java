import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int L,K,C;
        L = sc.nextInt();
        K = sc.nextInt();
        C = sc.nextInt();
        int []locations = new int[K];
        for ( int i = 0; i < K; i++)
        {
            locations[i] = sc.nextInt();
        }
    }
}
