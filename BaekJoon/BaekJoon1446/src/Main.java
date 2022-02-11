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
            return Integer.compare(this.dist, i.dist);
        }
    }
    static int n,d;
    static ArrayList<ArrayList<Info>> node;
    static int [] distance;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        node = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        distance = new int[d+1];
        Arrays.fill(distance,INF);
        for ( int i = 0; i <= d; i++)
        {
            node.add(new ArrayList<>());
        }
        for ( int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if ( s > d || e > d || e-s <= dist)
            {
                continue;
            }
            node.get(s).add(new Info(e,dist));
        }
        Dijkstra(0);
        bw.write(distance[d]+"\n");
        bw.flush();
        bw.close();
    }
    static void Dijkstra(int start)
    {
        distance[start] = 0;
        PriorityQueue<Info> que = new PriorityQueue<>();
        que.add(new Info(0,0));
        while(!que.isEmpty())
        {
            Info in = que.poll();
            int e = in.e;
            int dist = in.dist;
            if ( distance[e] < dist)
            {
                continue;
            }
            for ( int i = 0; i < node.get(e).size(); i++)
            {
                int n_dist = dist + node.get(e).get(i).dist;
                int n_e = node.get(e).get(i).e;
                if ( n_dist < distance[n_e])
                {
                    distance[n_e] = n_dist;
                    que.offer(new Info(n_e,n_dist));
                }
            }
            if ( e + 1 <= d && distance[e+1] > dist+1)
            {
                distance[e+1] = dist+1;
                que.offer(new Info(e+1,dist+1));
            }
        }
    }
}
