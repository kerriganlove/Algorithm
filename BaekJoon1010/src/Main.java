import java.math.BigInteger;
import java.util.Scanner;

public class Main
{
    static BigInteger[] a = new BigInteger[30*30+1];
    static boolean[] check = new boolean[30*30+1];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] list = new int[N][2];
        for (int i = 0; i < N; i++)
        {
            list[i][0] = sc.nextInt();
            list[i][1] = sc.nextInt();
        }
        a[1] = (BigInteger.ONE); check[1] = true;
        a[2] = (BigInteger.valueOf(2)); check[2] = true;
        BigInteger a,b,c;
        for ( int j = 0; j < N; j++)
        {
            a = factorial(list[j][0]);
            b = factorial(list[j][1]);
            c = factorial(list[j][1]-list[j][0]);

            System.out.println(b.divide(c.multiply(a)));
        }
    }
    public static BigInteger factorial(int input)
    {
        if ( input == 0 ) { return BigInteger.ONE; }
        for (int k = 3; k < input+1; k++)
        {
            if (check[k] == false)
            {
                a[k] = factorial(k-1).multiply(BigInteger.valueOf(k));
                check[k] = true;
            }
        }
        return a[input];
    }
}
