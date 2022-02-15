import java.io.*;
import java.util.*;

public class Main
{
    static long [] dp = new long[101];
    static long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Arrays.fill(dp,INF);
        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        StringBuilder numSb;
        for ( int i = 8; i < 101; i++)
        {
            for ( int j = 2; j <= i-2; j++)
            {
                numSb = new StringBuilder();
                long start = dp[j];
                long end = (i-j != 6) ? dp[i-j] : 0;
                numSb.append(start);
                numSb.append(end);
                long num = Long.parseLong(numSb.toString());
                dp[i] = Math.min(dp[i],num);
            }
        }
        for (int i = 0; i < T; i++)
        {
            int val = Integer.parseInt(br.readLine());
            sb.append(min(val)+" "+max(val)+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static String min(int value)
    {
        return Long.toString(dp[value]);
    }
    static String max(int value)
    {
        StringBuilder sb = new StringBuilder();
        if (value%2 == 0)
        {
            for ( int i = 0; i < value/2; i++)
            {
                sb.append(1);
            }
        }
        else
        {
            sb.append(7);
            for ( int i = 0; i < (value-2)/2; i++)
            {
                sb.append(1);
            }
        }
        return sb.toString();
    }
}
