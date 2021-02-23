import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    static int [][] map;
    static int [][] copy;
    static boolean [][] visited;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int N,M;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copy = new int[N][M];
        visited = new boolean[N][M];
        for ( int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        int answer = 0;
        while(result <= 1)
        {
            result = 0;
            for ( int i = 1; i < N-1; i++) {
                for ( int j = 1; j < M-1; j++) {
                    if (DFS(i, j)) { result++; }
                }
            }
            if ( result == 0) { answer = 0; break; }
            else if ( result == 1 ) {
                copy = deepCopy(map);
                melt();
                map = deepCopy(copy);
                answer++;
            }
            for ( int i = 1; i < N-1; i++)
            {
                Arrays.fill(copy[i],0);
                Arrays.fill(visited[i],false);
            }
        }
        System.out.println(answer);
    }
    static void melt()
    {
        int count = 0;
        for ( int i = 1; i < N-1; i++)
        {
            for ( int j = 1; j < M-1; j++)
            {
                if ( map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if ( map[nx][ny] == 0) { count++; }
                    }
                }
                copy[i][j] = Math.max(map[i][j] - count,0);
                count = 0;
            }
        }
    }
    public static int[][] deepCopy(int[][] org)
    {
        if ( org == null) { return null; }
        int[][] ans = new int[org.length][org[0].length];
        for ( int i = 0; i < org.length; i++)
        {
            System.arraycopy(org[i],0,ans[i],0,org[i].length);
        }
        return ans;
    }
    static boolean DFS(int x, int y)
    {
        if (( 0 > x && x >= N && 0 > y && y >= M))
        {
            return false;
        }
        else
        {
            if ( map[x][y] != 0 && !visited[x][y] )
            {
                visited[x][y] = true;
                for ( int i = 0; i < 4; i++)
                {
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    DFS(nx,ny);
                }
                return true;
            }
        }
        return false;
    }
}
