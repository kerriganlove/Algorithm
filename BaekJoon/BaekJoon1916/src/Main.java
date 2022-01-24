import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
    static int n,m;
    static ArrayList<ArrayList<Info>> edge;
    static int [] distance;
    static int INF = 987654321;
    static class Info implements Comparable<Info>
    {
        int end;
        int dist;
        public Info(int end, int dist)
        {
            this.end = end;
            this.dist = dist;
        }
        @Override
        public int compareTo(Info i)
        {
            return this.dist - i.dist;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        distance = new int[n+1];
        Arrays.fill(distance,INF);
        edge = new ArrayList<ArrayList<Info>>();
        m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for ( int i = 0; i <= n; i++)
        {
            edge.add(new ArrayList<>());
        }
        for ( int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edge.get(s).add(new Info(e,d));
        }
        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Dijkstra(start);
        bw.write(distance[end]+"\n");
        bw.flush();
        bw.close();
    }
    static void Dijkstra(int start)
    {
        int cost = 0;
        PriorityQueue<Info> que = new PriorityQueue<>();
        que.add(new Info(start,0));
        distance[start] = 0;
        while(!que.isEmpty())
        {
            Info i = que.poll();
            int dist = i.dist;
            int now = i.end;
            if ( distance[now] < dist) { continue; }
            for ( int k = 0; k < edge.get(now).size(); k++)
            {
                int que_dist = edge.get(now).get(k).dist;
                int que_end = edge.get(now).get(k).end;
                cost = dist + que_dist;
                if ( cost < distance[que_end])
                {
                    distance[que_end] = cost;
                    que.add(new Info(que_end,cost));
                }
            }
        }
    }
}
