import java.io.*;
import java.util.*;

public class Main
{
    static int [][][] map;
    static boolean [][][] visited;
    static int N,M,H;
    static int tomatoes = 0;
    static int answer = -1;
    static int [] dx = { -1,1,0,0,0,0};
    static int [] dy = { 0,0,-1,1,0,0};
    static int [] dz = {0,0,0,0,1,-1};
    static class Point
    {
        int x;
        int y;
        int z;
        int count;
        public Point(int x, int y, int z, int count)
        {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1][H+1];
        visited = new boolean[N+1][M+1][H+1];
        for ( int k = 1; k <= H; k++) {
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 0) {
                        tomatoes++;
                    }
                    map[i][j][k] = num;
                }
            }
        }
        if ( tomatoes == 0)
        {
            answer = 0;
        }
        else {
            BFS();
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static void BFS()
    {
        Queue<Point> que = new LinkedList<>();
        int ans = 0;
        for ( int k = 1; k <= H; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j][k] == 1) {
                        que.add(new Point(i, j, k, 0));
                    }
                }
            }
        }
        while(!que.isEmpty())
        {
            Point p = que.poll();
            if ( ans == tomatoes )
            {
                answer = p.count;
                while (!que.isEmpty())
                {
                    answer = Math.max(answer, que.poll().count);
                }
                break;
            }
            for ( int i = 0; i < 6; i++)
            {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];
                if ( 0 < nx && nx <= N && 0 < ny && ny <= M && 0 < nz && nz <= H )
                {
                    if ( !visited[nx][ny][nz] && map[nx][ny][nz] == 0)
                    {
                        visited[nx][ny][nz] = true;
                        map[nx][ny][nz] = 1;
                        ans++;
                        que.add(new Point(nx,ny,nz,p.count+1));
                    }
                }
            }
        }
    }
}

