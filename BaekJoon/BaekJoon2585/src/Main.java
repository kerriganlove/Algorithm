import java.util.*;
import java.io.*;

public class Main
{
    static int n,k;
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
    static Point[] list;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new Point[n+1];
        list[0] = new Point(0,0);
        for ( int i = 1; i <= n; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[i] = new Point(x,y);
        }
        int s = 0;
        int e = 14150; // 10000*root(2)의 값...?
        int ans = 0;
        while(s <= e)
        {
            int mid = (s+e)/2;
            if (BFS(mid))
            {
                ans = mid;
                e = mid-1;
            }
            else
            {
                s = mid+1;
            }
        }
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
    }
    static boolean BFS(int mid)
    {
        boolean [] check = new boolean[n+1];
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        int fuel = mid*10;
        while(!que.isEmpty())
        {
            int size = que.size();
            if ( cnt > k)
            {
                return false;
            }
            for ( int i = 0; i < size; i++)
            {
                int p = que.poll();
                if ( !check[p]) {
                    check[p] = true;
                    for (int j = 1; j <= n; j++) {
                        Point p2 = list[j];
                        double start = Math.sqrt(Math.pow(list[p].x - p2.x, 2) + Math.pow(list[p].y - p2.y, 2));
                        if (start <= fuel) {
                            double end = Math.sqrt(Math.pow(10000 - p2.x, 2) + Math.pow(10000 - p2.y, 2));
                            if (end <= fuel) {
                                return true;
                            }
                            que.add(j);
                        }
                    }
                }
            }
            cnt++;
        }
        return false;
    }
}
