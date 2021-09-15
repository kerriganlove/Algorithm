import javax.print.attribute.IntegerSyntax;
import java.util.*;
import java.io.*;

public class Main
{
    static class Point
    {
        int end;
        int cost;
        public Point(int end, int cost)
        {
            this.end = end;
            this.cost = cost;
        }
    }
    static int n,m;
    static int start,end;
    static boolean [] visited;
    static ArrayList<ArrayList<Point>> al = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for ( int i = 0; i <= n; i++)
        {
            al.add(new ArrayList<Point>());
        }
        for ( int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            al.get(s).add(new Point(e,dir));
            al.get(e).add(new Point(s,dir));
        }
        st = new StringTokenizer(br.readLine()," ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        int s = 0;
        int e = (int) Math.pow(10,9);
        while ( s <= e )
        {
            int mid = (s+e)/2;
            visited = new boolean[n+1];
            if (BFS(start, end, mid))
            {
                s = mid+1;
            }
            else
            {
                e = mid-1;
            }
        }
        bw.write(e+"\n");
        bw.flush();
        bw.close();
    }
    static boolean BFS(int start, int end, int mid)
    {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        while(!que.isEmpty())
        {
            int e = que.poll();
            if ( e == end)
            {
                return true;
            }
            for ( Point p : al.get(e))
            {
                if (!visited[p.end] && mid <= p.cost)
                {
                    visited[p.end] = true;
                    que.add(p.end);
                }
            }
        }
        return false;
    }
}
