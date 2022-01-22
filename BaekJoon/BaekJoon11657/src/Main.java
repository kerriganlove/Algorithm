import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    static class Info
    {
        int start;
        int end;
        int dist;
        public Info(int start, int end, int dist)
        {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }
    static Info [] roads;
    static long [] distance;
    static int n,m;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distance = new long[n+1];
        roads = new Info[m];
        Arrays.fill(distance,INF);
        for ( int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            roads[i] = new Info(s,e,d);
        }
        if(!bellmanFord(1))
        {
            bw.write("-1\n");
        }
        else
        {
            for ( int i = 2; i <= n; i++)
            {
                if (distance[i] == INF)
                {
                    bw.write("-1\n");
                }
                else
                {
                    bw.write(distance[i]+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
    static boolean bellmanFord(int start)
    {
        distance[start] = 0;

        for ( int i = 0; i < n-1; i++)
        {
            for ( int j = 0; j < m; j++)
            {
                Info in = roads[j];
                int s = in.start;
                int e = in.end;
                int d = in.dist;
                if ( distance[s] == INF) continue;
                if ( distance[e] > distance[s] + d)
                {
                    distance[e] = distance[s] + d;
                }
            }
        }
        for ( int i = 0; i < m; i++)
        {
            Info in = roads[i];
            int s = in.start;
            int e = in.end;
            int d = in.dist;
            if ( distance[s] == INF) continue;
            if ( distance[e] > distance[s] + d)
            {
                return false;
            }
        }
        return true;
    }
}
