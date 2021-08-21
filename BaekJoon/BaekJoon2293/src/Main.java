import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] list = new int[N];
        int [] dp = new int[K+1];
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for ( int i : list)
        {
            for ( int j = i; j <= K; j++)
            {
                dp[j] += dp[j-i];
            }
        }
        bw.write(dp[K]+"\n");
        bw.flush();
        bw.close();
    }
}
