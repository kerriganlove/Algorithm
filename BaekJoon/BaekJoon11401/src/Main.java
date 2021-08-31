import java.io.*;
import java.util.*;

public class Main
{
    static int mod = 1000000007;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long [] dp = new long[N+1];
        dp[0] = 1;
        dp[1] = 1;
        for ( int i = 2; i <= N; i++ )
        {
            dp[i] = (dp[i-1]*i)%mod;
        }
        long perma = (dp[K]*dp[N-K])%mod;
        long par = pow(perma, mod-2);
        long baby = dp[N];
        long answer = (baby*par) % mod;
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static long pow(long par, long expo)
    {
        if (expo == 1)
        {
            return (par % mod);
        }
        else
        {
            long temp = pow(par,expo/2);
            if ( expo % 2 == 1)
            {
                return ((((temp*temp) % mod) * par)%mod);
            }
            return (temp * temp)%mod;
        }
    }
}
