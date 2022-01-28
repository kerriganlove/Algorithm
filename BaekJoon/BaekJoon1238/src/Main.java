import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
{
    static class Info implements Comparable<Info>
    {
        int y;
        int dist;
        public Info(int y, int dist)
        {
            this.y = y;
            this.dist = dist;
        }
        @Override
        public int compareTo(Info i)
        {
            return this.dist - i.dist;
        }
    }
    static ArrayList<ArrayList<Info>> edge, edge2;
    static int [] distance;
    static int [] answer;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        edge = new ArrayList<>();
        edge2 = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        distance = new int[n+1];
        answer = new int[n+1];
        Arrays.fill(distance, INF);
        for ( int i = 0; i <= n; i++)
        {
            edge.add(new ArrayList<>());
            edge2.add(new ArrayList<>());
        }
        for ( int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edge.get(s).add(new Info(e,d));
            edge2.get(e).add(new Info(s,d));
        }
        Dijkstra(x,edge);
        for ( int i = 1; i <= n; i++)
        {
            answer[i]+=distance[i];
        }
        Arrays.fill(distance, INF);
        Dijkstra(x,edge2);
        for ( int i = 1; i <= n; i++)
        {
            answer[i]+=distance[i];
        }
        int max = -1;
        for ( int i = 1; i <= n; i++)
        {
            max = Math.max(answer[i],max);
        }
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
    static void Dijkstra(int start, ArrayList<ArrayList<Info>> edge)
    {
        int cost = 0;
        distance[start] = 0;
        PriorityQueue<Info> que = new PriorityQueue<>();
        que.add(new Info(start,0));
        while(!que.isEmpty())
        {
            Info i = que.poll();
            int now = i.y;
            int dist = i.dist;
            if ( distance[now] < dist) { continue; }
            for ( int j = 0; j < edge.get(now).size(); j++)
            {
                cost = dist + edge.get(now).get(j).dist;
                if ( cost < distance[edge.get(now).get(j).y])
                {
                    distance[edge.get(now).get(j).y] = cost;
                    que.add(new Info(edge.get(now).get(j).y, cost));
                }
            }
        }
    }
}
