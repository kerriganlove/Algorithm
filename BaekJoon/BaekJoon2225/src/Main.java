import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long [][] dp = new long[K+1][N+1];
        int mod = 1000000000;
        for ( int i = 0; i <= N; i++)
        {
            dp[1][i] = 1;
        }
        for ( int i = 2; i <= K; i++)
        {
            for ( int j = 0; j <=N; j++)
            {
                for ( int l = 0; l <= j; l++)
                {
                    dp[i][j] += dp[i-1][j-l];
                }
                dp[i][j] %= mod;
            }
        }
        System.out.println(dp[K][N]);
    }
}
