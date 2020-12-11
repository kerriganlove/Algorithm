import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main
{
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new BigInteger[501];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        factorial(N);
        String s = dp[N].toString();
        int answer = 0;
        for ( int i = s.length()-1; i > -1; i--)
        {
            if (s.charAt(i) == '0')
            {
                answer++;
            }
            else { break; }
        }
        System.out.println(answer);
    }
    public static void factorial(int num)
    {
        for ( int i = 2; i < num+1; i++)
        {
            dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));
        }
    }
}
