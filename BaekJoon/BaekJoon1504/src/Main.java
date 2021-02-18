import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] distance;
    static ArrayList<ArrayList<Info>> edge;
    static int INF = 987654321;
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
        Arrays.fill(distance,INF);
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
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        edge = new ArrayList<>();
        for ( int i = 0; i <= N; i++)
        {
            edge.add(new ArrayList<>());
        }
        distance = new int[N+1];
        for ( int i = 0; i < E; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edge.get(a).add(new Info(c,b));
            edge.get(b).add(new Info(c,a));
        }
        Dijkstra(1);
        st = new StringTokenizer(br.readLine()," ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int result1 = distance[x]; //2
        int result2 = distance[y]; //3
        Dijkstra(x);
        result2 += distance[N];
        result1 += distance[y];
        Dijkstra(y);
        result1 += distance[N];
        result2+= distance[x];
        int min = Math.min(result1, result2);
        System.out.println(min >= INF || min < 0 ? -1 : min);
    }
}
