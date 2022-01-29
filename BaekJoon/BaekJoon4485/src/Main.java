import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    static int [][] map;
    static int n;
    static int [] dx = { -1,1,0,0};
    static int [] dy = { 0,0,-1,1};
    static int [][] answer;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 1;
        while(true)
        {
            n = Integer.parseInt(br.readLine());
            if ( n == 0) { break; }
            map = new int[n][n];
            answer = new int[n][n];
            for ( int i = 0; i < n; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for ( int j = 0; j < n; j++)
                {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j] = num;
                    answer[i][j] = INF;
                }
            }
            BFS(0,0);
            bw.write("Problem "+cnt+++": "+answer[n-1][n-1]+"\n");
        }
        bw.flush();
        bw.close();
    }
    static void BFS(int x, int y)
    {
        Queue<int []> que = new LinkedList<>();
        que.add(new int [] { x,y });
        answer[0][0] = map[0][0];
        while(!que.isEmpty())
        {
            int [] poll = que.poll();
            int mx = poll[0];
            int my = poll[1];
            for ( int i = 0; i < 4; i++)
            {
                int nx = mx + dx[i];
                int ny = my + dy[i];
                if ( 0 <= nx && nx < n && 0 <= ny && ny < n)
                {
                    if ( answer[nx][ny] > map[nx][ny] + answer[mx][my] )
                    {
                        answer[nx][ny] = map[nx][ny] + answer[mx][my];
                        que.add(new int[]{nx, ny});
                    }
                }
            }
        }

    }
}
