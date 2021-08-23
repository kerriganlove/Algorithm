import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int [] dp = new int[1001];
        int [] list = new int[N+1];
        for ( int i = 1; i <= N; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int answer = -1;
        dp[1] = 1;
        for ( int i = 2; i <= N; i++)
        {
            for ( int j = 1; j<= i; j++)
            {
                if ( list[i] > list[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        for ( int num : dp)
        {
            answer = Math.max(num,answer);
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();

    }
}
