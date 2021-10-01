import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static long cnt;
    static int [][] map;
    static long [][] dp;
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new long[n][n];
        visited = new boolean[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = DFS(0,0);
        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
    }
    static long DFS(int x, int y)
    {
        if ( x == n-1 && y == n-1)
        {
            return 1;
        }
        if ( !visited[x][y]) {
            visited[x][y] = true;
            int dir = map[x][y];
            int nx = x + dir;
            int ny = y + dir;
            if (nx < n) {
                dp[x][y] += DFS(nx,y);
            }
            if ( ny < n)
            {
                dp[x][y] += DFS(x,ny);
            }
        }
        return dp[x][y];
    }
}
