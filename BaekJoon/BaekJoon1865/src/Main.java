import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
class Node
{
    int edge;
    int weight;
    public Node(int edge, int weight) {
        this.edge = edge;
        this.weight = weight;
    }
}
public class Main
{
    static ArrayList<ArrayList<Node>> list;
    static int N,M,W;
    static int [] dist;
    static int INF = 859028520;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            dist = new int[N+1];
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for ( int i = 0; i <= N; i++)
            {
                list.add(new ArrayList<>());
            }
            for ( int i = 0; i < M+W; i++)
            {
                st = new StringTokenizer(br.readLine()," ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                if ( i < M) { list.get(s).add(new Node(e,t)); list.get(e).add(new Node(s,t)); }
                else { list.get(s).add(new Node(e,-t));}
            }
            sb.append((Bellman_ford()) ? "YES\n" : "NO\n");
            T--;
        }
        System.out.print(sb.toString());
    }
    public static boolean Bellman_ford()
    {
        Arrays.fill(dist,INF);
        dist[1] = 0;
        boolean check = false;
        for ( int i = 1; i < N; i++)
        {
            for ( int j = 1; j <=N; j++) {
                for (Node n : list.get(j)) {
                    if (dist[n.edge] > dist[j] + n.weight) {
                        dist[n.edge] = dist[j] + n.weight;
                        check = true;
                    }
                }
            }
            if (!check) { break; }
        }
        for ( int i = 1; i <= N; i++)
        {
            for ( Node n : list.get(i))
            {
                if ( dist[n.edge] > dist[i] + n.weight)
                {
                    return true;
                }
            }
        } // 음의 사이클을 판별하는 방법.
        return false;
    }
}
