import java.io.*;

public class Main
{
    static int [][] dp;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        dp = new int[10001][4];
        for ( int i = 1; i <= 3; i++)
        {
            for ( int j = 1; j <= i; j++)
            {
                dp[i][j] = 1;
            }
        }
        for ( int i = 4; i <= 10000; i++)
        {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }
        while(T > 0)
        {
            int n = Integer.parseInt(br.readLine());
            int sum = dp[n][1] + dp[n][2] + dp[n][3];
            bw.write(sum+"\n");
            T--;
        }
        bw.flush();
        bw.close();
    }
}
