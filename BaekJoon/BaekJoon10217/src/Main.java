import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
    static int T,N,M,K;
    static int[][] distance;
    static ArrayList<ArrayList<Info>> edge;
    static int INF = 100000000;
    public static class Info implements Comparable<Info>
    {
        int node;
        int length;
        int cost;

        public Info(int length, int node, int cost)
        {
            this.node = node;
            this.length = length;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            if ( this.length < o.length ) { return -1; }
            else if ( this.length == o.length) {
                if (this.cost < o.cost) {
                    return -1;
                }
            }
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        String [] answer = new String[T+1];
        while (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            distance = new int[N + 1][10001];
            edge = new ArrayList<ArrayList<Info>>();
            for (int j = 1; j < N + 1; j++) {
                Arrays.fill(distance[j], INF);
            }
            for ( int j = 0; j<=K; j++)
            {
                edge.add(new ArrayList<Info>());
            }
            for (int i = 0; i < K; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st2.nextToken());
                int v = Integer.parseInt(st2.nextToken());
                int c = Integer.parseInt(st2.nextToken());
                int d = Integer.parseInt(st2.nextToken());
                edge.get(u).add(new Info(d, v, c));
            }
            Dijkstra(1);
            int min = INF;
            for (int i = 1; i < M+1; i++) {
                    min = Math.min(min, distance[N][i]);
            }
            if ( min == INF) { answer[T] = "Poor KCM";}
            else { answer[T] = Integer.toString(min); }
            T--;
        }
        for ( int i = answer.length-1; i > 0; i--)
        {
            System.out.println(answer[i]);
        }
    }
    public static void Dijkstra(int start)
    {
        int cost = 0;
        int money = 0;
        int node = 0;
        PriorityQueue<Info> que = new PriorityQueue<>();
        que.add(new Info(0,start,0));
        distance[start][0] = 0;
        while (!que.isEmpty())
        {
            Info x = que.poll();
            int dist = x.length;
            int now = x.node;
            int cost1 = x.cost;
            if ( now == N ) { break; }
            if ( cost1 > M ) { continue; }
            if (distance[now][cost1] < dist) { continue; }
            for (int k = 0; k < edge.get(now).size(); k++)
            {
                node = edge.get(now).get(k).node;
                cost = dist + edge.get(now).get(k).length;
                money = cost1 + edge.get(now).get(k).cost;
                if ( money > M ) { continue; }
                if ( cost < distance[node][money])
                {
                    distance[node][money] = cost;
                    que.offer(new Info(cost,node,money));
                }
            }
        }
    }
}
