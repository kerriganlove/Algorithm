import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static int n;
    static int [][] line;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        line = new int[n+1][n+1];
        for ( int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if ( i == j) { line[i][j] = 0; }
                else { line[i][j] = INF; }
            }
        }
        int m = Integer.parseInt(br.readLine());
        for ( int i = 0; i < m; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            line[s][e] = Math.min(line[s][e], d);
        }
        floydWarshall();
        for ( int i = 1; i <= n; i++)
        {
            for ( int j = 1; j <= n; j++)
            {
                if ( i == j || line[i][j] == INF) { bw.write(0+" "); }
                else { bw.write(line[i][j]+" "); }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    static void floydWarshall()
    {
        for ( int i = 1; i <= n; i++)
        {
            for ( int j = 1; j <= n; j++)
            {
                for ( int k = 1; k <= n; k++)
                {
                    line[j][k] = Math.min(line[j][k], line[j][i] + line[i][k]);
                }
            }
        }
    }
}
