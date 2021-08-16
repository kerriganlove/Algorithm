import java.io.*;
import java.util.*;

public class Main3
{
    static int [][] map;
    static int [][] dp;
    static int MAX = 987654321;
    static int ans = MAX;
    static int N,M;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        for ( int i = 1; i <= N; i++)
        {
            for ( int j = 1; j <= M; j++)
            {
                map[i][j] = br.read()-48;
                dp[i][j] = (map[i][j] == 0) ? 0 : MAX;
            }
            br.read();
        }
        dp[1][1] = 1;
        ans = (ans == MAX) ? -1 : ans;
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
    }
}
