import java.io.*;
import java.util.*;
public class Main
{
    static int N,M;
    static int [][] map;
    static int [] dx = { -1,1,0,0};
    static int [] dy = { 0,0,-1,1};
    static boolean [][][] visited;
    static int MAX = 987654321;
    static class Point
    {
        int x;
        int y;
        int count;
        boolean isWall;
        public Point(int x, int y,int count, boolean isWall)
        {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isWall = isWall;
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
        visited = new boolean[N+1][M+1][2];
        int answer = MAX;
        for ( int i = 1; i <= N; i++)
        {
            for ( int j = 1; j <= M; j++)
            {
                map[i][j] = br.read()-48;
            }
            br.read();
        }
        answer = BFS();
        if ( answer == MAX)
        {
            bw.write("-1\n");
        }
        else { bw.write(answer+"\n"); }
        bw.flush();
        bw.close();
    }
    static int BFS()
    {
        int ans = MAX;
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(1,1,1,true));
        visited[1][1][0] = true;
        visited[1][1][1] = true;
        while (!que.isEmpty())
        {
            Point p = que.poll();
            if ( p.x == N && p.y == M)
            {
                ans = p.count;
                break;
            }
            for ( int k = 0; k < 4; k++)
            {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if ( 0 < nx && nx <= N && 0 < ny && ny <= M)
                {
                    if (map[nx][ny] == 1 && p.isWall)
                    {
                        que.add(new Point(nx,ny,p.count+1,false));
                    }
                    else if (map[nx][ny] == 0 ) {
                        if ( !visited[nx][ny][0] && !p.isWall)
                        {
                            visited[nx][ny][0] = true;
                            que.add(new Point(nx, ny,p.count+1,p.isWall));

                        }
                        else if (!visited[nx][ny][1] && p.isWall) {
                            visited[nx][ny][1] = true;
                            que.add(new Point(nx, ny,p.count+1,p.isWall));

                        }
                    }
                }
            }
        }
        return ans;
    }
}
