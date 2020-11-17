import java.util.Scanner;

public class BottomWork
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] table = new int[1001];
        table[1] = 1;
        table[2] = 3;
        for ( int i = 3; i < N+1; i++)
        {
            table[i] = ((table[i-1]) + (table[i-2]*2)) % 796796;
        }
        System.out.print(table[N]);
    }
}
