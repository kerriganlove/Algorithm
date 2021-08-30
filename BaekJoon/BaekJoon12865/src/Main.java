import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] w = new int[N+1];
        int [] v = new int[N+1];
        int [][] dp = new int[N+1][K+1];
        for ( int i = 1; i <= N; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        for ( int i = 1; i <= N; i++)
        {
            for (int j = 1; j <=K; j++)
            {
                // 배냥의 남은 용량 + 담고 싶은 물건 > 총 배낭의 무게
                if (w[i] > j)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else // 담을 수 있게 된다면
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
                }
            }
        }
        bw.write(dp[N][K]+"\n");
        bw.flush();
        bw.close();
    }
}
