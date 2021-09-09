import java.io.*;
import java.util.*;

public class Main
{
    static int [][] map;
    static int [][] temp;
    static int n,m;
    static int answer, empty;
    static class Point
    {
        int x;
        int y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    static int [] dx = { -1,1,0,0};
    static int [] dy = { 0,0,-1,1};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        temp = new int[n][m];
        for ( int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            for ( int j = 0; j < m; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for ( int i = 0; i < n; i++)
        {
            for ( int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    mapCopy(map, temp);
                    temp[i][j] = 1;
                    wall(1);
                    temp[i][j] = 0;
                }
            }
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static void mapCopy(int [][] org, int [][] copy)
    {
        for ( int i = 0; i < org.length; i++)
        {
            System.arraycopy(org[i],0,copy[i],0,org[i].length);
        }
    }
    static void wall(int cnt)
    {
        if ( cnt == 3)
        {
            BFS();
            return ;
        }
        for ( int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
            {
                if ( temp[i][j] == 0)
                {
                    temp[i][j] = 1;
                    wall(cnt+1);
                    temp[i][j] = 0;
                }
            }
        }
    }
    static void BFS()
    {
        int [][] bfsCopy = new int[n][m];
        boolean [][] visited = new boolean[n][m];
        mapCopy(temp,bfsCopy);
        Queue<Point> que = new LinkedList<>();
        for ( int i = 0; i < n; i++)
        {
            for ( int j = 0; j < m; j++)
            {
                if ( bfsCopy[i][j] == 2)
                {
                    que.add(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }
        while(!que.isEmpty())
        {
            Point p = que.poll();
            for ( int i = 0; i < 4; i++)
            {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if ( 0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!visited[nx][ny])
                    {
                        if (bfsCopy[nx][ny] == 0)
                        {
                            visited[nx][ny] = true;
                            bfsCopy[nx][ny] = 2;
                            que.add(new Point(nx,ny));
                        }
                    }
                }
            }
        }
        for ( int i = 0; i < n; i++)
        {
            for ( int j = 0; j < m; j++)
            {
                if ( bfsCopy[i][j] == 0)
                {
                    empty++;
                }
            }
        }
        answer = Math.max(empty,answer);
        empty = 0;
    }
}
