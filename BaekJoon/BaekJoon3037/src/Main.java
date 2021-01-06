import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long mod = 1000000007;
        long [][] dp = new long[1001][10001];
        int max = 0;
        dp[1][0] = 1;
        for ( int i = 2; i <=N; i++ )
        {
            max += i-1; // 최대 혼란도 구하기
            dp[i][0] = 1;
            int length = Math.min(10000,max);
            for ( int j = 1; j <= length; j++)
            {
                dp[i][j] = ((dp[i][j-1]%mod)+(dp[i-1][j]%mod))%mod;
                if ( j-i >= 0) { dp[i][j] = ((dp[i][j]%mod) - (dp[i-1][j-i])+mod)%mod; }
            }
        }
        System.out.println(dp[N][C]);
    }
}
