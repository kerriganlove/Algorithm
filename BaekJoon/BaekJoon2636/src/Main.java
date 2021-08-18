import java.util.*;
import java.io.*;
public class Main
{
    static int [][] map;
    static boolean [][] visited;
    static int N,M;
    static int cheeze;
    static int ans = 0;
    static int pre = 0;
    static int [] dx = { -1,1,0,0};
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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for ( int i = 1; i <= N; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            for ( int j = 1; j <= M; j++)
            {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if ( num == 1) { cheeze++; }
            }
        }
        while(cheeze != 0) {
            makeAir();
            BFS();
            ans+=1;
        }
        bw.write(ans+"\n"+pre+"\n");
        bw.flush();
        bw.close();
    }
    static void BFS()
    {
        Queue<Point> que = new LinkedList<>();
        visited = new boolean[N+1][M+1];
        for ( int i = 2; i < N; i++)
        {
            for ( int j = 2; j < M; j++)
            {
                if ( map[i][j] == 1) {
                    que.add(new Point(i, j, 0));
                }
            }
        }
        while(!que.isEmpty())
        {
            Point p = que.poll();
            if ( cheeze == 0)
            {
                pre = que.size() + 1;
                break;
            }
            for ( int i = 0; i < 4; i++)
            {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if ( 0 < nx && nx <= N && 0 < ny && ny <= M)
                {
                    if (!visited[nx][ny] && map[nx][ny] == -1 && map[p.x][p.y] == 1)
                    {
                        map[p.x][p.y] = -1;
                        visited[p.x][p.y] = true;
                        cheeze--;
                        que.add(new Point(p.x,p.y,p.count+1));
                    }
                }
            }
        }

    }
    static void makeAir()
    {
        Queue<Point> que = new LinkedList<>();
        visited = new boolean[N+1][M+1];
        que.add(new Point(1,1,0));
        map[1][1] = -1;
        while(!que.isEmpty())
        {
            Point p = que.poll();
            for ( int i = 0; i < 4; i++)
            {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if ( 0 < nx && nx <= N && 0 < ny && ny <= M) {
                    if ((map[nx][ny] == 0 || map[nx][ny] == -1 )&& !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        map[nx][ny] = -1;
                        que.add(new Point(nx, ny, 0));
                    }
                }
            }
        }
    }
}
