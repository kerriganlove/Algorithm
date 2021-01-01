import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static long [] dp = new long[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < N; i++)
        {
            solve(Integer.parseInt(st.nextToken()));
        }
        for ( int i = 1; i < dp.length; i++)
        {
            if ( dp[i] >= 2) { max = Math.max(max,dp[i] * i); }
        }
        System.out.println(max);
    }
    static void solve(int num)
    {
       for ( int i = 1; i * i <= num; i++)
       {
           if ( num % i == 0) {
               dp[i]++;
               if ( i != num / i) { dp[num/i]++; }
           }
       }
    }
}
