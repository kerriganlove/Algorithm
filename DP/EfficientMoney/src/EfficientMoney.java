import java.util.Arrays;
import java.util.Scanner;

public class EfficientMoney
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] units = new int[N];
        for (int i = 0; i < N; i++)
        {
            units[i] = sc.nextInt();
        }
        int[] table = new int[10001];
        Arrays.fill(table,10001);
        table[0] = 0;

        for (int unit : units)
        {
            for ( int j = unit; j < M+1; j++)
            {
                if (table[j-unit] != 10001)
                {
                    table[j] = Math.min(table[j],table[j-unit]+1);
                }
            }
        }
        if ( table[M] == 10001) { System.out.print(-1); }
        else { System.out.print(table[M]); }
    }
}
