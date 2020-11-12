import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class MazeRunner
{
    static int N,M;
    static int [][]map;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        String str;
        for ( int i = 0; i < N; i++)
        {
            str = sc2.nextLine();
            for ( int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j)-48;
            }
        }
        int answer = bfs(0,0);
        System.out.println(answer);
    }
    public static int bfs(int x, int y)
    {
        int nx,ny;
        int condition = 0;
        int []xy = new int[2];
        nx = x; ny = y;
        q.add(new int[]{nx, ny});
        while(!q.isEmpty())
        {
            xy = q.poll();
            nx = xy[0]; ny = xy[1];
            switch(condition)
            {
                case 0: if (nx-1 > -1 && map[nx-1][ny] == 1)
                {
                    map[nx-1][ny] = map[nx][ny]+1;
                    q.add(new int[]{nx-1,ny});
                } else { condition = 1; }
                case 1: if (ny+1 < M && map[nx][ny+1] == 1)
                {
                    map[nx][ny+1] = map[nx][ny]+1;
                    q.add(new int[]{nx,ny+1});
                    condition = 0;
                } else { condition = 2; }
                case 2: if (nx+1 < N && map[nx+1][ny] == 1)
                {
                    map[nx+1][ny] = map[nx][ny] + 1;
                    q.add(new int[]{nx+1,ny});
                    condition = 0;
                } else { condition = 3; }
                case 3: if (ny-1 > -1 && map[nx][ny-1] == 1)
                {
                    map[nx][ny-1] = map[nx][ny]+1;
                    q.add(new int[]{nx,ny-1});
                    condition = 0;
                } else { condition = 0; }
            }
        }
        return map[N-1][M-1];
    }
}
