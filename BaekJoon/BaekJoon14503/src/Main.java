import java.util.*;
import java.io.*;

public class Main
{
    static int [][] map;
    static int n,m;
    static int answer;
    static class Point
    {
        int x;
        int y;
        int dir;
        public Point(int x, int y, int dir)
        {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static int [] dx = { -1,0,1,0};
    static int [] dy = { 0,1,0,-1};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        st = new StringTokenizer(br.readLine()," ");
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int sdir = Integer.parseInt(st.nextToken());
        Point stp = new Point(sx,sy,sdir);
        for ( int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            for ( int j = 0; j < m; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS(stp);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 2) {
                        answer++;
                    }
                }
            }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static void BFS(Point p)
    {
        Queue<Point> que = new LinkedList<>();
        map[p.x][p.y] = 2;
        que.add(p);
        while(!que.isEmpty())
        {
            Point po = que.poll();
            int dir = moveDir(po.dir,0);
            for ( int i = 0; i < 5; i++)
            {
                if ( i == 4)
                {
                    int b_dir = moveDir(po.dir,1);
                    int nx = po.x + dx[b_dir];
                    int ny = po.y + dy[b_dir];
                    if ( 0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if ( map[nx][ny] != 1)
                        {
                            que.add(new Point(nx,ny,po.dir));
                        }
                    }
                }
                else {
                    int nx = po.x + dx[dir];
                    int ny = po.y + dy[dir];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (map[nx][ny] == 0) {
                            map[nx][ny] = 2;
                            que.add(new Point(nx, ny, dir));
                            break;
                        } else {
                            dir = moveDir(dir, 0);
                        }
                    }
                }
            }
        }
    }
    static int moveDir(int dir, int cnt)
    {
        int ans = 0;
        switch(cnt)
        {
            case 0 :
                switch(dir)
                {
                    case 0 : ans = 3; break;
                    case 1 : ans = 0; break;
                    case 2 : ans = 1; break;
                    case 3 : ans = 2; break;
                }
                break;
            case 1 :
                switch(dir)
                {
                    case 0 : ans = 2; break;
                    case 1 : ans = 3; break;
                    case 2 : ans = 0; break;
                    case 3 : ans = 1; break;
                }
                break;
        }
        return ans;
    }
}
