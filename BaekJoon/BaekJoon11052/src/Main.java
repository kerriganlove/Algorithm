import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int [] list = new int[N+1];
        int [] dp = new int[N+1];
        for ( int i = 1; i <= N; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
            dp[i] = list[i];
        }
        for ( int i = 2; i <= N; i++)
        {
            for ( int j = 1; j <= i; j++)
            {
                dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
            }
        }
        bw.write(dp[N]+"\n");
        bw.flush();
        bw.close();
    }
}
