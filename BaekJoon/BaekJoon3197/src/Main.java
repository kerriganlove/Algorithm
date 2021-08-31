import java.util.*;
import java.io.*;

public class Main
{
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
    static char [][] map;
    static int [] dx = { -1,1,0,0};
    static int [] dy = { 0,0,-1,1};
    static int R,C;
    static Point start;
    static Queue<Point> que = new LinkedList<>();
    static Queue<Point> nque = new LinkedList<>();
    static Queue<Point> mapQue = new LinkedList<>();
    static Queue<Point> mapNque = new LinkedList<>();
    static boolean [][] visited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R+1][C+1];
        for ( int i = 1; i <= R; i++)
        {
            for (int j = 1; j <= C; j++)
            {
                map[i][j] = (char) br.read();
                if ( map[i][j] == 'L' ) {
                    if ( start == null) {
                        start = new Point(i, j);
                    }
                    mapQue.add(new Point(i,j));
                }
                if ( map[i][j] == '.')
                {
                    mapQue.add(new Point(i,j));
                }
            }
            br.read();
        }
        que.add(start);
        visited = new boolean[R+1][C+1];
        visited[start.x][start.y] = true;
        int day = 0;
        while(!catchBFS()) {
            day++;
            mapBFS();
            while(!nque.isEmpty())
            {
                que.add(nque.poll());
            }
            while(!mapNque.isEmpty()) {
                mapQue.add(mapNque.poll());
            }
        }
        bw.write(day+"\n");
        bw.flush();
        bw.close();
    }
    static boolean catchBFS()
    {
        while(!que.isEmpty())
        {
            Point p = que.poll();
            for ( int i = 0; i < 4; i++)
            {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if ( 0 < nx && nx <= R && 0 < ny && ny <= C)
                {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == '.' ) {
                            que.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                        else if (map[nx][ny] == 'X') {
                            nque.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                        else if (map[nx][ny] == 'L') {
                            visited[nx][ny] = true;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    static void mapBFS()
    {
        while(!mapQue.isEmpty())
        {
            Point p = mapQue.poll();
            for ( int i = 0; i < 4; i++)
            {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if ( 0 < nx && nx <= R && 0 < ny && ny <= C )
                {
                    if ( map[nx][ny] == 'X' )
                    {
                        map[nx][ny] = '.';
                        mapNque.add(new Point(nx,ny));
                    }
                }
            }
        }
    }
}

