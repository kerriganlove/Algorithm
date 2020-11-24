import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        int mod = 1000000000;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        long [][] dp = new long[N+1][10];
        Arrays.fill(dp[0],0);
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;
        for ( int i = 2; i < N+1; i++)
        {
            for ( int j = 0; j < 10; j++)
            {
                if (j == 0) { dp[i][j] = (dp[i-1][j+1]) % mod; }
                else if (j == 9) { dp[i][j] = (dp[i-1][j-1]) % mod; }
                else { dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]) % mod; }
            }
        }
        long sum = 0;
        for ( int i = 0; i < 10; i++)
        {
            sum += dp[N][i];
            sum %= mod;
        }
        System.out.print(sum%mod);
    }
}
