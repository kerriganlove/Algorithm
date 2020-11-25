import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long [][] dp = new long[N+1][21];
        dp[1][Integer.parseInt(st.nextToken())]++;
        int cur = 0;
        int cnt = 1;
        while(st.hasMoreTokens())
        {
            cur = Integer.parseInt(st.nextToken());
            cnt++;
            for (int i = 0; i <= 20; i++)
            {
                if (dp[cnt-1][i] != 0)
                {
                    if (i+cur <= 20) { dp[cnt][i+cur] += dp[cnt-1][i]; }
                    if (i-cur >= 0) { dp[cnt][i-cur] += dp[cnt-1][i]; }
                }
            }
        }
        System.out.println(dp[cnt-1][cur]);
        // 오늘의 교훈 : 1. DP 풀때는 조건값을 잘 보고 DP TABLE을 결정하면 된다.
    }
}
