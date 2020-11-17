import java.util.Scanner;

public class AntSoldier
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] house = new int[N];
        int[] table = new int[100];
        for ( int i = 0; i < N; i++ )
        {
            house[i] = sc.nextInt();
        }
        table[0] = house[0];
        table[1] = Math.max(house[0],house[1]);
        for ( int j = 2; j < N; j++)
        {
            table[j] = Math.max(table[j-1], table[j-2] + house[j]);
        }
        System.out.print(table[N-1]);

    }
}
