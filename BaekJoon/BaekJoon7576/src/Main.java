import java.io.*;
import java.util.*;

public class Main
{
    static int [][] map;
    static int [][] ans;
    static int answer = -1;
    static int N,M;
    static boolean [][] visited;
    static int [] dx = { -1,1,0,-0};
    static int [] dy = { 0,0,-1,1};
    static class Point
    {
        int x;
        int y;
        int count;
        public Point(int x, int y, int count)
        {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        ans = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for ( int i = 1; i <= N; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j <= M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != -1) {
                    ans[i][j] = 1;
                }
                else { ans[i][j] = -1; }
            }
        }
        BFS();
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static void BFS()
    {
        Queue<Point> que = new LinkedList<>();
        int tomatoCount = 0;
        int exit = 0;
        for (int i = 1; i <= N; i++)
        {
            for ( int j = 1; j <= M; j++)
            {
                if ( map[i][j] == 1)
                {
                    que.add(new Point(i,j,0));
                    visited[i][j] = true;
                }
                else if ( map[i][j] == 0)
                {
                    tomatoCount++;
                }
            }
        }
        while(!que.isEmpty())
        {
            Point p = que.poll();
            if ( tomatoCount == exit )
            {
                answer = Math.max(answer,p.count);
                while(!que.isEmpty())
                {
                    p = que.poll();
                    answer = Math.max(answer,p.count);
                }
                break;
            }
            for ( int i = 0; i < 4; i++)
            {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 < nx && nx <= N && 0 < ny && ny <= M) {
                    if (!visited[nx][ny] && map[nx][ny] == 0)
                    {
                        visited[nx][ny] = true;
                        map[nx][ny] = 1;
                        exit++;
                        que.add(new Point(nx,ny,p.count+1));
                    }
                }
            }
        }
    }
}
