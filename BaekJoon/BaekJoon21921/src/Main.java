import java.io.*;
import java.util.*;

public class Main
{
    static int [] dp;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n+1];
        st = new StringTokenizer(br.readLine()," ");
        int sum = 0;
        for ( int i = 1; i <= n; i++)
        {
            sum+= Integer.parseInt(st.nextToken());
            dp[i] = sum;
        }
        int max = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for ( int i = 1; i <= n; i++)
        {
            if ( i < k)
            {
                continue;
            }
            int num = dp[i] - dp[i-k];
            list.add(num);
            max = Math.max(num,max);
        }
        list.sort(Collections.reverseOrder());
        int ans2 = 0;
        for ( int i : list)
        {
            if ( i < max )
            {
                break;
            }
            if ( i == max)
            {
                ans2++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max+"\n"+ans2+"\n");
        bw.write(max == 0 ? "SAD\n" : sb.toString());
        bw.flush();
        bw.close();
    }
}
