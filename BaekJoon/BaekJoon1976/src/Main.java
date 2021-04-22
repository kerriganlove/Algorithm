import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int [][] arr = new int[N+1][N+1];
        int INF = 987654321;
        for ( int i = 1; i < N+1; i++)
        {
            Arrays.fill(arr[i],INF);
            arr[i][i] = 0;
        }
        for ( int i = 1; i < N+1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for ( int j = 1; j < N+1; j++)
            {
                int dist = Integer.parseInt(st.nextToken());
                if (dist != 0) { arr[i][j] = dist; }
            }
        }
        for ( int i = 1; i < N+1; i++)
        {
            for ( int j = 1; j < N+1; j++)
            {
                for ( int k = 1; k < N+1; k++)
                {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }
        String s = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s," ");
        int pre = Integer.parseInt(st2.nextToken());
        for ( int i = 0; i < M-1; i++)
        {
            int next = Integer.parseInt(st2.nextToken());
            if ( arr[pre][next] >= INF) { sb.append("NO"); break; }
        }
        System.out.println(sb.toString().equals("NO") ? sb.toString() : "YES" );
    }
}
