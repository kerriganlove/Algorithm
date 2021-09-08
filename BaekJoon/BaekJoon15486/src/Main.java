import java.util.*;
import java.io.*;
public class Main
{
    static class Info
    {
        int day;
        int cost;
        public Info(int day, int cost)
        {
            this.day = day;
            this.cost = cost;
        }
    }
    static int MAX = 1500000;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Info[] list = new Info[N+2];
        for ( int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[i] = new Info(d,c);
        }
        list[N+1] = new Info(0,0);
        int [] dp = new int[MAX+2];
        int max = 0;
        for (int i = 1; i <= N+1; i++) {
            max = Math.max(max, dp[i]);
            if (i + list[i].day > N + 1) {
                continue;
            }
            dp[i + list[i].day] = Math.max(dp[i + list[i].day], max + list[i].cost);
        }
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
}
