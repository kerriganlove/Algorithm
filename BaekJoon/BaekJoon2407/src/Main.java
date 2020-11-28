import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main
{
    static BigInteger[] dp;
    static boolean[] checked;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new BigInteger[N+1];
        checked = new boolean[N+1];
        dp[1] = BigInteger.ONE; checked[1] = true;
        dp[2] = BigInteger.valueOf(2); checked[2] = true;
        BigInteger answer = factorial(N).divide(factorial(M).multiply(factorial(N-M)));
        System.out.println(answer);
    }
    public static BigInteger factorial(int x)
    {
        BigInteger answer = BigInteger.ZERO;
        for ( int i = 2; i < x+1; i++)
        {
            if ( checked[i] == true)
            {
                continue;
            }
            else if (checked[i] == false)
            {
                checked[i] = true;
                dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));
            }
        }
        answer = dp[x];
        return answer;
    }
}
