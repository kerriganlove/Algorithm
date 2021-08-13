import java.io.*;
import java.util.*;

public class Main2 // DFS + DP is wrong.
{
    static int[] list;
    static boolean[] visited;
    static int[] dp;
    static int N;
    static int max = -1;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        list = new int[N+1];
        visited = new boolean[N+1];
        for ( int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        DFS(0);
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
    static void DFS(int num)
    {
        visited[num] = true;
        if ( num >= 3)
        {
            if ( visited[num-2] && visited[num-1] )
            {
                visited[num] = false;
                return ;
            }
        }
        if ( num == N )
        {
            max = Math.max(dp[N],max);
            return ;
        }
        if ( num <= N-1) {
            dp[num + 1] = dp[num] + list[num + 1];
            DFS(num + 1);
            dp[num + 1] = 0;
            visited[num+1] = false;
            if ( num <= N-2) {
                dp[num + 2] = dp[num] + list[num + 2];
                DFS(num + 2);
            }
        }
    }
}
