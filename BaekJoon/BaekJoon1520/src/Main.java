import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    static int [][] map;
    static int [][] dp;
    static int [] dx = { 0, 0, 1, -1};
    static int [] dy = { 1, -1, 0, 0};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            for ( int j = 0; j < N; j++)
            {
                dp[i][j] = -1;
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(DFS(0,0));
    }
    public static int DFS(int x, int y)
    {
        if ( x == M-1 && y == N-1 ) { return 1; }
        else if ( dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++)
            {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if (0 <= cx && cx < M && 0 <= cy && cy < N && map[x][y] > map[cx][cy]) {
                    dp[x][y] += DFS(cx, cy);
                }
            }
        }
        return dp[x][y];
    }
}
