import java.lang.reflect.Array;
import java.util.*;

public class Telegram
{
    static int[] distance;
    static ArrayList<ArrayList<Info>> edge;
    public static class Info implements Comparable<Info>
    {
        int node;
        int length;

        public Info(int length, int node)
        {
            this.node = node;
            this.length = length;
        }

        @Override
        public int compareTo(Info o) {
            if ( this.length < o.length ) { return -1; }
            return 1;
        }
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
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int C = sc.nextInt();
        int INF = 1000000000;
        edge = new ArrayList<ArrayList<Info>>();
        for ( int i = 0; i <= N; i++)
        {
            edge.add(new ArrayList<Info>());
        }
        for ( int i = 0; i < M; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            edge.get(x).add(new Info(z,y));
        }
        distance = new int[N+1];
        Arrays.fill(distance,INF);

        Dijkstra(C);

        int count = 0;
        int max_distance = 0;
        for ( int l = 1; l < N+1; l++)
        {
            if ( distance[l] != INF) { count += 1; max_distance = Math.max(max_distance, distance[l]); }

        }
        System.out.print(count - 1 + " " + max_distance);
    }
}
