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

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        line = new int[n+1][n+1];
        int m = Integer.parseInt(st.nextToken());
        for ( int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            line[start][end] = 1;
        }
        floydWarshall();
        int s = Integer.parseInt(br.readLine());
        for ( int i = 0; i < s; i++ )
        {
            st = new StringTokenizer(br.readLine()," ");
            int st2 = Integer.parseInt(st.nextToken());
            int en2 = Integer.parseInt(st.nextToken());
            if ( line[st2][en2] == 0 && line[en2][st2] == 0) { bw.write("0"+"\n"); }
            else if ( line[st2][en2] < line[en2][st2])
            {
                bw.write("1"+"\n");
            }
            else
            {
                bw.write("-1"+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
    static void floydWarshall()
    {
        for ( int i = 1; i <= n; i++)
        {
            for ( int j = 1; j <= n ; j++)
            {
                for (int k = 1; k <= n; k++)
                {
                    if ( line[j][i] == 1 && line[i][k] == 1 )
                    {
                        line[j][k] = 1;
                    }
                }
            }
        }
    }
}
