import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    static int[] list;
    static int[] dp;
    static int N;
    static int M;
    public static boolean isOK(int value)
    {
        int sum = 0;
        int count = 1;
        int cur;
        for ( int i = 1; i < N+1; i++)
        {
           cur = dp[i]-dp[sum];
           if ( cur > value)
           {
               sum = i-1;
               count++;
           }
        }
        return count <= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N + 1];
        dp = new int[N + 1];
        int i = 1;
        String s2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s2, " ");
        while (st2.hasMoreTokens()) {
            list[i++] = Integer.parseInt(st2.nextToken());
        }
        dp[1] = list[1];
        for (int j = 2; j < N + 1; j++) {
            dp[j] = dp[j - 1] + list[j];
        }
        Arrays.sort(list);
        int start = list[N];
        int end = dp[N];
        int middle;
        while (start <= end) {
            middle = (start + end) / 2;
            if (isOK(middle)) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        System.out.println(start);

        int cur2 = 0;
        int sum2 = 0;
        int answer = 0;
        for (int k = 1; k < N + 1; k++) {
            cur2 = dp[k] - dp[sum2];
            if (cur2 > start) {
                sum2 = k - 1;
                M--;
                System.out.print(answer + " ");
                answer = 0;
            }
            answer++;
            if (N - (k - 1) == M) {
                break;
            }
        }
        while (M-- > 0) {
            if (M != 0) {
                System.out.print(answer + " ");
            } else {
                System.out.print(answer);
            }
            answer = 1;
        }
    }
}

