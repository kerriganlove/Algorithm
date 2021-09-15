import java.util.*;
import java.io.*;
public class Main2
{
    static int n,m;
    static class Point implements Comparable<Point>
    {
        int end;
        int cost;
        public Point(int end, int cost)
        {
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Point p)
        {
            return this.cost - p.cost;
        }
    }
    static int start, end;
    static int [] list;
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
        list = new int[n+1];
        Arrays.fill(list,-1);
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
        Dijkstra(start);
        bw.write(list[end]+"\n");
        bw.flush();
        bw.close();
    }
    static void Dijkstra(int start)
    {
        int cost = 0;
        PriorityQueue<Point> que = new PriorityQueue<>();
        que.add(new Point(start,987654321));
        list[start] = 987654321;
        while(!que.isEmpty())
        {
            Point p = que.poll();
            int end = p.end;
            int co = p.cost;

            if (list[end] > co) { continue; }
            for ( int i = 0; i < al.get(end).size(); i++)
            {
                cost = Math.min(co,al.get(end).get(i).cost);
                if ( cost > list[al.get(end).get(i).end])
                {
                    list[al.get(end).get(i).end] = cost;
                    que.add(new Point(al.get(end).get(i).end,cost));
                }
            }
        }
    }
}
