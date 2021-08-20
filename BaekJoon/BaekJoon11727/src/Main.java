import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1];
        dp[1] = 1;
        if ( N >= 2 ) { dp[2] = 3; }
        for ( int i = 3; i <= N; i++)
        {
            dp[i] = (dp[i-1] + (dp[i-2] * 2)) % 10007;
        }
        bw.write(dp[N]+"\n");
        bw.flush();
        bw.close();
    }
}
