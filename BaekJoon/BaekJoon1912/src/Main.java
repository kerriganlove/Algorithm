import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] list = new int[N];
        int [] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = list[0];
        int answer = list[0];
        for ( int i = 1; i < N; i++)
        {
            dp[i] = Math.max(list[i], dp[i-1]+list[i]);
            answer = Math.max(dp[i],answer);
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
