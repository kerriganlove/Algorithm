import java.util.*;
import java.io.*;

public class Main
{
    static int n,m;
    static char [][] map;
    static boolean [][][][] visited;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static class Point
    {
        int rx,ry;
        int bx,by;
        int count;
        public Point(int rx, int ry, int bx, int by, int count)
        {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n+1][m+1];
        visited = new boolean[n+1][m+1][n+1][m+1];
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;
        for ( int i = 1; i <= n; i++)
        {
            for ( int j = 1; j <= m; j++)
            {
                map[i][j] = (char) br.read();
                if ( map[i][j] == 'R')
                {
                    rx = i;
                    ry = j;
                }
                else if ( map[i][j] == 'B')
                {
                    bx = i;
                    by = j;
                }
            }
            br.read();
        }
        Point start = new Point(rx,ry,bx,by,0);
        map[rx][ry] = '.';
        map[bx][by] = '.';
        int ans = BFS(start);
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
    }
    static int BFS(Point p)
    {
        Queue<Point> que = new LinkedList<>();
        que.add(p);
        visited[p.rx][p.ry][p.bx][p.by] = true;
        int answer = -1;
        while(!que.isEmpty())
        {
            Point p1 = que.poll();
            if ( p1.count > 10)
            {
                answer = -1;
                break;
            }
            if (map[p1.bx][p1.by] == 'O')
            {
                continue;
            }
            if (map[p1.rx][p1.ry] == 'O' && map[p1.bx][p1.by] != 'O')
            {
                answer = p1.count;
                break;
            }
            for ( int i = 0; i < 4; i++)
            {
                int rx = p1.rx+dx[i];
                int ry = p1.ry+dy[i];
                int bx = p1.bx+dx[i];
                int by = p1.by+dy[i];
                int r_cnt = 0;
                int b_cnt = 0;
                while(true)
                {
                    if ( map[rx][ry] != '#' && map[rx][ry] != 'O' )
                    {
                        rx += dx[i]; ry+= dy[i];
                    }
                    else {
                        if (map[rx][ry] == '#') {
                            rx -= dx[i];
                            ry -= dy[i];
                        }
                        break;
                    }
                    r_cnt++;
                }
                while(true)
                {
                    if ( map[bx][by] != '#' && map[bx][by] != 'O')
                    {
                        bx += dx[i]; by+= dy[i];
                    }
                    else {
                        if (map[bx][by] == '#') {
                            bx -= dx[i];
                            by -= dy[i];
                        }
                        break;
                    }
                    b_cnt++;
                }
                if ( rx == bx && ry == by)
                {
                    if ( map[rx][ry] != 'O')
                    {
                        if ( r_cnt > b_cnt)
                        {
                            rx -= dx[i];
                            ry -= dy[i];
                        }
                        else
                        {
                            bx -= dx[i];
                            by -= dy[i];
                        }
                    }
                }
                if (!visited[rx][ry][bx][by])
                {
                    visited[rx][ry][bx][by] = true;
                    que.add(new Point(rx,ry,bx,by,p1.count+1));
                }
            }
        }
        return answer;
    }
}