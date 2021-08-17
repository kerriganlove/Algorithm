import java.io.*;
import java.util.*;

public class Main
{
    static int [] list;
    static boolean [] isTeam;
    static boolean [] isRoute;
    static boolean [] visited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while ( T > 0)
        {
            int N = Integer.parseInt(br.readLine());
            int ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            list = new int[N+1];
            isTeam = new boolean[N+1];
            isRoute = new boolean[N+1];
            visited = new boolean[N+1];
            for ( int i = 1; i <= N; i++)
            {
                int idx = Integer.parseInt(st.nextToken());
                if ( i == idx ) { isTeam[i] = true; visited[i] = true; isRoute[i] = true;}
                list[i] = idx;
            }
            for ( int i = 1; i <= N; i++)
            {
                if (!visited[i]) {
                    DFS(i);
                }
            }
            for ( boolean b : isTeam)
            {
                if (!b) { ans++; }
            }
            bw.write(ans-1+"\n");
            T--;
        }
        bw.flush();
        bw.close();
    }
    static void DFS(int n)
    {
        visited[n] = true;
        if ( visited[list[n]])
        {
            if (!isRoute[list[n]])
            {
                for ( int i = list[n]; i != n; i = list[i])
                {
                    isTeam[i] = true;
                }
                isTeam[n] = true;
            }
        }
        else
        {
            DFS(list[n]);
        }
        isRoute[n] = true;
    }
}
