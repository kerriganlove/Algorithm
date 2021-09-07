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
        int [] list = new int[N];
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int [] dp = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        for ( int i = 0; i < N; i++)
        {
            list[i] -= b;
            dp[i]++;
        }
        for ( int i = 0; i < N; i++)
        {
            if ( list[i] <= 0) { continue; }
            else
            {
                int div = list[i] / c;
                int mod = list[i] - (div*c);
                if ( mod != 0)
                {
                    div+=1;
                }
                dp[i] += div;
            }
        }
        long answer = 0;
        for ( int i : dp)
        {
            answer+=i;
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
