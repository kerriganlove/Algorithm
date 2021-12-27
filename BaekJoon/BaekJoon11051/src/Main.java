import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int mod = 10007;
        long dp [][] = new long[1001][1002];
        dp[1][1] = 1;
        dp[1][2] = 1;
        for ( int i = 2; i < 1001; i++)
        {
            dp[i][1] = 1;
            dp[i][i+1] = 1;
        }
        for ( int i = 2; i < 1001; i++)
        {
            for ( int j = 2; j < 1002; j++)
            {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%mod;
            }
        }
        bw.write(dp[n][m+1]+"\n");
        bw.flush();
        bw.close();
    }
}
