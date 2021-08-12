import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int N;
    static int M;
    static class Point
    {
        int x;
        int y;
        int cnt;
        public Point(int x, int y, int cnt)
        {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for ( int i = 1; i <= N; i++)
        {
            for ( int j = 1; j <= M; j++)
            {
                map[i][j] = br.read()-48;
            }
            br.read();
        }

        int answer = BFS();
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static int BFS()
    {
        Queue<Point> que = new LinkedList<>();
        int ans = 987654321;
        int cnt = 1;
        que.add(new Point(1,1,cnt));
        while(!que.isEmpty())
        {
            Point p = que.poll();
            if ( p.x == N && p.y == M)
            {
                ans = p.cnt;
                break;
            }
            for ( int i = 0; i < 4; i++)
            {
                int nx = p.x - dx[i];
                int ny = p.y - dy[i];
                if ( 0 < nx && nx <= N && 0 < ny && ny <= M)
                {
                    if ( map[nx][ny] == 1 && !visited[nx][ny])
                    {
                        visited[nx][ny] = true;
                        que.add(new Point(nx,ny,p.cnt+1));
                    }
                }
            }
        }
        return ans;
    }
}
