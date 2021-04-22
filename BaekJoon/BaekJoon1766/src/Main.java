import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> degree = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] deg = new int[N+1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= N; i++)
        {
            degree.add(new ArrayList<>());
        }
        for ( int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            degree.get(x).add(y);
            deg[y]++;
        }
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for ( int i = 1; i <= N; i++)
        {
            if ( deg[i] == 0) { que.add(i); }
        }
        while (!que.isEmpty())
        {
            int dx = que.poll();
            sb.append(dx+" ");
            for ( int i = 0; i < degree.get(dx).size(); i++)
            {
                int dy = degree.get(dx).get(i);
                if ( --deg[dy] == 0 ) { que.add(dy); }
            }
        }
        System.out.println(sb.toString());
    }
}
