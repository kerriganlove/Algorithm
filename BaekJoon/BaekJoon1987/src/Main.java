import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static int [][] map;
    static boolean [] visited;
    static int n,m;
    static int [] dx = { -1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int max = -1;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[26];
        for ( int i = 0; i < n; i++)
        {
            String s = br.readLine();
            for ( int j = 0; j < m; j++)
            {
                map[i][j] = ((int)s.charAt(j
                ))-65;
            }
        }
        DFS(0,0, 1);
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
    static void DFS(int x, int y, int answer)
    {
        if ( x < 0 || x >= n || y < 0 || y >= m )
        {
            return ;
        }
        if ( visited[map[x][y]] ) {
            return ;
        }
        visited[map[x][y]] = true;
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ( 0 <= nx && nx < n && 0 <= ny && ny < m)
            {
                if (map[nx][ny] != map[x][y] && !visited[map[nx][ny]])
                {
                    DFS(nx,ny,answer+1);
                }
            }
        }
        visited[map[x][y]] = false;
        max = Math.max(max,answer);
    }
}
