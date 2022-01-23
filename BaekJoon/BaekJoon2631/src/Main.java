import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int [] list = new int[n+1];
        int [] dp = new int[n+1];
        for ( int i = 1; i <= n; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
        }
        int max = -1;
        for ( int i = 1; i <= n; i++)
        {
            dp[i] = 1;
            for ( int j = 1; j <= i; j++)
            {
                if ( list[j] < list[i] && dp[i] < dp[j]+1)
                {
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(dp[i],max);
        }
        bw.write(n-max+"\n");
        bw.flush();
        bw.close();
    }
}
