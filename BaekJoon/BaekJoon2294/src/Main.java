import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        int [] dp = new int[100001];
        Arrays.fill(dp,10001);
        dp[0] = 0;
        int [] list = new int[N];
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
            dp[list[i]] = 1;
        }
        for ( int i = 1; i <= total; i++)
        {
            for ( int j = 0; j < N; j++)
            {
                if ( i-list[j] < 0) { continue; }
                else dp[i] = Math.min(dp[i-list[j]]+1, dp[i]);
            }
        }
        System.out.println((dp[total] != 10001) ? dp[total] : -1);

    }
}
