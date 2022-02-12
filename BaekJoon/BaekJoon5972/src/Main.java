import java.io.*;
import java.util.*;

public class Main
{
    static class Info implements Comparable<Info>
    {
        int e;
        int dist;
        public Info(int e, int dist)
        {
            this.e = e;
            this.dist = dist;
        }
        @Override
        public int compareTo(Info i)
        {
            return this.dist - i.dist;
        }
    }
    static ArrayList<ArrayList<Info>> node;
    static int [] distance;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        node = new ArrayList<>();
        distance = new int[n+1];
        Arrays.fill(distance,INF);
        for ( int i = 0; i <= n; i++)
        {
            node.add(new ArrayList<>());
        }
        for ( int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            node.get(s).add(new Info(e,d));
            node.get(e).add(new Info(s,d));
        }
        Dijkstra(1);
        bw.write(distance[n]+"\n");
        bw.flush();
        bw.close();
    }
    static void Dijkstra(int start)
    {
        distance[start] = 0;
        PriorityQueue<Info> que = new PriorityQueue<>();
        que.add(new Info(start,0));
        while(!que.isEmpty())
        {
            Info in = que.poll();
            int st = in.e;
            int dist = in.dist;
            if ( distance[st] < dist)
            {
                continue;
            }
            for ( int i = 0; i < node.get(st).size(); i++)
            {
                int n_st = node.get(st).get(i).e;
                int n_dist = node.get(st).get(i).dist;
                int cost = dist + n_dist;
                if ( cost < distance[n_st])
                {
                    distance[n_st] = cost;
                    que.add(new Info(n_st, cost));
                }
            }
        }
    }
}
