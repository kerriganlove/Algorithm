import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    static boolean visited[];
    static ArrayList<Point> home = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();
    static int MAX = 987654321;
    static int answer;
    static int N,M;
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
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for ( int i = 1; i <= N; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            for ( int j = 1; j <= N; j++)
            {
                int num = Integer.parseInt(st.nextToken());
                if ( num == 1)
                {
                    home.add(new Point(i,j));
                }
                else if ( num == 2)
                {
                    chicken.add(new Point(i,j));
                }
            }
        }
        visited = new boolean[chicken.size()+1];
        answer = MAX;
        DFS(0,0);

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static void DFS(int chick_num, int chick_cnt)
    {
        if ( chick_num > chicken.size())
        {
            return ;
        }
        if ( chick_cnt == M)
        {
            int tmp = 0;
            int dist_min = 0;
            for ( int i = 0; i < home.size(); i++)
            {
                Point p1 = home.get(i);
                dist_min = MAX;
                for ( int j = 0; j < chicken.size(); j++)
                {
                    if ( visited[j])
                    {
                        Point p2 = chicken.get(j);
                        int dist = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
                        dist_min = Math.min(dist,dist_min);
                    }
                }
                tmp += dist_min;
            }
            answer = Math.min(tmp,answer);
            return ;
        }
        visited[chick_num] = true;
        DFS(chick_num+1, chick_cnt+1); // 치킨 집 방문 카운트
        visited[chick_num] = false;
        DFS(chick_num+1, chick_cnt); // 다음 치킨집에 대해서 Count...
    }
}
