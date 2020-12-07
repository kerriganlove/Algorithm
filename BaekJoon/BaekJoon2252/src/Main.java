import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
    static Queue<Integer> que = new LinkedList<>();
    static int[] degree;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        degree = new int[N+1];
        for ( int i = 0; i <= N; i++)
        {
            map.add(new ArrayList<Integer>());
        }
        for ( int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            degree[b]++;
            map.get(a).add(b);
        }
        for ( int i = 1; i <=N; i++)
        {
            if ( degree[i] == 0 ) { que.add(i); }
        }
        while(!que.isEmpty())
        {
            int d = que.poll();
            System.out.print(d+" ");
            for (int i = 0; i < map.get(d).size(); i++)
            {
                int l = --degree[map.get(d).get(i)];
                if ( l == 0) { que.add(map.get(d).get(i)); }
            }
        }
    }
}
