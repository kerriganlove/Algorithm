import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> arr = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = new BigDecimal(st.nextToken()).multiply(BigDecimal.valueOf(100)).intValue();
            if ( N == 0 && M == 0 ) { break; }
            int[][] list = new int[N][2];
            for ( int i = 0; i < N; i++)
            {
                st = new StringTokenizer(br.readLine()," ");
                list[i][0] = Integer.parseInt(st.nextToken());
                list[i][1] = new BigDecimal(st.nextToken()).multiply(BigDecimal.valueOf(100)).intValue();
            }
            int [] dp = new int[M+1];
            for ( int i = 0; i <= M; i++)
            {
                for ( int j = 0; j < N; j++)
                {
                    if ( i - list[j][1] >= 0)
                    {
                        dp[i] = Math.max(dp[i],dp[i-list[j][1]]+list[j][0]);
                    }
                }
            }
            arr.add(dp[M]);
        }
        for ( int i : arr)
        {
            System.out.println(i);
        }
    }
}
