import java.io.*;
public class Main
{
    static class Counts
    {
        int zero;
        int one;
        public Counts(int zero, int one)
        {
            this.zero = zero;
            this.one = one;
        }
    }
    static Counts[] dp = new Counts[41];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        dp[0] = new Counts(1,0);
        dp[1] = new Counts(0,1);
        dp[2] = new Counts(1,1);
        for ( int i = 3; i <= 40; i++)
        {
            dp[i] = new Counts(dp[i-1].zero+dp[i-2].zero, dp[i-1].one+dp[i-2].one);
        }
        while( T > 0)
        {
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N].zero + " " + dp[N].one+"\n");
            T--;
        }
        bw.flush();
        bw.close();
    }
}
