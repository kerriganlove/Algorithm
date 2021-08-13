import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1];
        int [] list = new int[N+1];
        for ( int i = 1; i <= N; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = list[1];
        if ( N >= 2)
        {
            dp[2] = list[1]+list[2];
        }
        for ( int i = 3; i <= N; i++)
        {
            dp[i] = Math.max(dp[i-2], dp[i-3] + list[i-1]) + list[i];
        }
        bw.write(dp[N]+"\n");
        bw.flush();
        bw.close();
    }
}
