import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
    static int[] distance;
    static int INF = 1000000000;
    public static class Info implements Comparable<Info>{
        int length;
        int node;

        public Info(int length, int node) {
            this.length = length;
            this.node = node;
        }

        @Override
        public int compareTo(Info o) {
            if ( this.length < o.length ) { return -1; }
            return 1;
        }
    }
    static ArrayList<ArrayList<Info>> edge = new ArrayList<ArrayList<Info>>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        distance = new int[N+1];
        Arrays.fill(distance,INF);
        for ( int i = 0; i <=N; i++)
        {
            edge.add(new ArrayList<Info>());
        }
        for ( int i = 0; i < M; i++)
        {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge.get(a).add(new Info(1,b));
            edge.get(b).add(new Info(1,a));
        }

        Dijkstra(1);
        int count = 0;
        for ( int k : distance) { if ( k!=INF) { count++;} }
        System.out.println(count-1);
    }
    public static void Dijkstra(int start)
    {
        int cost = 0;
        PriorityQueue<Info> que = new PriorityQueue<>();
        que.add(new Info(0,start));
        distance[start] = 0;
        while (!que.isEmpty())
        {
            Info x = que.poll();
            int dist = x.length;
            int now = x.node;

            if (distance[now] < dist) { continue; }
            for (int k = 0; k < edge.get(now).size(); k++)
            {
                cost = dist + edge.get(now).get(k).length;
                if ( cost < distance[edge.get(now).get(k).node])
                {
                    distance[edge.get(now).get(k).node] = cost;
                    que.offer(new Info(cost,edge.get(now).get(k).node));
                }
            }
        }
    }
}
