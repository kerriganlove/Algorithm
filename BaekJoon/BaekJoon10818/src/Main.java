import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int min = 1000000;
        int max = -1000000;
        int temp = 0;
        for (int i = 0; i < N; i++)
        {
            temp = sc.nextInt();
            if ( temp >= max) { max = temp; }
            if ( min >= temp ) { min = temp; }
        }
        System.out.print(min+" "+max);
    }
}
