import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] dp = new int[1000001];
        for ( int i = 2; i <= 1000000; i++)
        {
            dp[i] = dp[i-1]+1;
            if ( i % 2 == 0) { dp[i] = Math.min(dp[i],dp[i/2]+1); }
            if ( i % 3 == 0) { dp[i] = Math.min(dp[i],dp[i/3]+1); }
        }
        int N = Integer.parseInt(br.readLine());
        bw.write(dp[N]+"\n");
        bw.flush();
        bw.close();
    }
}
