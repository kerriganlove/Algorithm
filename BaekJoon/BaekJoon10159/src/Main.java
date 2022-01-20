import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static int [][] line;
    static int n;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        line = new int[n+1][n+1];
        int m = Integer.parseInt(br.readLine());
        for ( int i = 0; i < m; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            line[s][e] = 1;
        }
        floydWarshall();
        for ( int i = 1; i <= n; i++)
        {
            int size = 0;
            for ( int j = 1; j <= n; j++)
            {
                if ( i == j) continue;
                size = (line[i][j] == 0 && line[j][i] == 0) ? size+1 : size;
            }
            bw.write(size+"\n");
        }
        bw.flush();
        bw.close();
    }
    static void floydWarshall()
    {
        for ( int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                for ( int k = 1; k <= n; k++)
                {
                    if ( line[j][i] == 1 && line[i][k] == 1) line[j][k] = 1;
                }
            }
        }
    }
}
