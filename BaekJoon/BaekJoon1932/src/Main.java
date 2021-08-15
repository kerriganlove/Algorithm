import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [][] dp = new int[N+1][N+1];
        int [][] list = new int[N+1][N+1];
        for ( int i = 1; i <= N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for ( int j = 1; j <= i; j++)
            {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for ( int i = 1; i <= N; i++)
        {
            dp[N][i] = list[N][i];
        }
        for ( int i = N-1; i >= 1; i--)
        {
            for (int j = 1; j <= N-1; j++)
            {
                dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+1]);
                dp[i][j] += list[i][j];
            }
        }
        System.out.println(dp[1][1]);
    }
}
