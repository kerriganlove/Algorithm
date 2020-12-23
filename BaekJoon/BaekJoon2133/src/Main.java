import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[31];
        dp[0] = 1;
        dp[2] = 3;
        for ( int i = 4; i<=N; i+=2)
        {
            dp[i] = dp[i-2]*dp[2];
            for ( int j = 4; i-j >= 0; j+=2)
            {
                dp[i] += dp[i-j]*2;
            }
        }
        System.out.println(N%2==1 ? 0 : dp[N]);
    }
}
