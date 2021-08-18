import java.io.*;
import java.util.*;
public class Main
{
    static int [][] map;
    static int N,M,K;
    static int num = 0;
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
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        ArrayList<Integer> list = new ArrayList<>();
        for ( int i = 0; i < K; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int bx = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            for ( int j = by; j < ey; j++)
            {
                for ( int k = bx; k < ex; k++)
                {
                    map[M-j-1][N-k-1] = 1;
                }
            }
        }
        for ( int i = 0; i < M; i++)
        {
            System.out.println(Arrays.toString(map[i]));
        }
        for (int i = 0; i < M; i++)
        {
            for ( int j = 0; j < N; j++)
            {
                if (DFS(i,j)) { list.add(num); num = 0; }
            }
        }
        Collections.sort(list);
        bw.write(list.size()+"\n");
        for ( int i : list)
        {
            bw.write(i+" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
    static boolean DFS(int y, int x)
    {
        if ( map[y][x] == 0 ) {
            map[y][x] = 1;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    DFS(ny, nx);
                }
            }
            num++;
            return true;
        }
        return false;
    }
}
