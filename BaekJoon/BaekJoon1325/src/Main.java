import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        answer = new int[N+1];
        for ( int i = 0; i <= N; i++) { graph[i] = new ArrayList<>(); }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            graph[y].add(x);
        }
        for ( int i = 1; i <=N; i++)
        {
            visited = new boolean[N+1];
            dfs(i);
        }
        for ( int i = 1; i <= N; i++)
        {
            max = Math.max(max,answer[i]);
        }
        int answers = 0;
        for (int i : answer)
        {
            if ( i == max) { System.out.print(answers+" "); }
            answers++;
        }
    }
    public static void dfs(int i)
    {
        visited[i] = true;
        for (int go : graph[i])
        {
            if (visited[go])
                continue;
            answer[go]++;
            dfs(go);
        }
    }
}
