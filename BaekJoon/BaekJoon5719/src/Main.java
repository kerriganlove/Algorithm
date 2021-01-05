import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] distance;
    static ArrayList<ArrayList<Info>> edge;
    static ArrayList<ArrayList<int[]>> path;
    static boolean [][] visited;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = -1; int M = -1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if ( N==0 && M == 0) { break; }
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            edge = new ArrayList<>();
            path = new ArrayList<>();
            visited = new boolean[N][N];
            distance = new int[N];
            for ( int i = 0; i < N; i++)
            {
                edge.add(new ArrayList<>());
                path.add(new ArrayList<>());
            }
            for ( int i = 0; i < M; i++)
            {
                st = new StringTokenizer(br.readLine()," ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                edge.get(u).add(new Info(d,v));
                path.get(v).add(new int[]{d,u});
            }
            Dijkstra(s,e);
            BFS(s,e);
            Dijkstra(s,e);
            sb.append(distance[e] == INF ? -1+"\n" : distance[e]+"\n");
        }
        System.out.print(sb.toString());
    }
    static void BFS(int start, int end)
    {
        Queue<Integer> que = new LinkedList<>();
        que.add(end);
        while (!que.isEmpty())
        {
            int over = que.poll();
            if ( over == start) { continue; }
            for ( int[] a : path.get(over))
            {
                int len = a[0];
                int node = a[1];
                if (distance[over] == distance[node]+len && !visited[node][over])
                {
                    visited[node][over] = true;
                    que.add(node);
                }
            }
        }
    }
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
    public static void Dijkstra(int start, int end)
    {
        int cost = 0;
        PriorityQueue<Info> que = new PriorityQueue<>();
        que.add(new Info(0,start));
        Arrays.fill(distance, INF);
        distance[start] = 0;
        while (!que.isEmpty())
        {
            Info x = que.poll();
            int dist = x.length;
            int now = x.node;

            if (distance[now] < dist) { continue; }
            for (int k = 0; k < edge.get(now).size(); k++)
            {
                int next = edge.get(now).get(k).node;
                cost = dist + edge.get(now).get(k).length;
                if ( cost < distance[next] && !visited[now][next])
                {
                    distance[next] = cost;
                    que.offer(new Info(cost,next));
                }
            }
        }
    }
}