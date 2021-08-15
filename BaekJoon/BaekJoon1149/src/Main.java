import java.io.*;
import java.util.*;

public class Main
{
    static int [][] list;
    static int [][] dp;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        list = new int[N+1][4];
        dp = new int[N+1][4];

        for ( int i = 1; i <= N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for ( int j = 1; j <= 3; j++)
            {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1] = list[1];
        for ( int i = 2; i <= N; i++)
        {
            for ( int j = 1; j <= 3; j++)
            {
                dp[i][j] = find(i,j) + list[i][j];
            }
        }
        int answer = 987654321;
        for ( int i = 1; i <= 3; i++)
        {
            answer = Math.min(dp[N][i],answer);
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static int find(int i,int j)
    {
        int min = 0;
        switch(j) {
            case 1 : min = Math.min(dp[i-1][2],dp[i-1][3]); break;
            case 2 : min = Math.min(dp[i-1][1],dp[i-1][3]); break;
            case 3 : min = Math.min(dp[i-1][1],dp[i-1][2]); break;
            default : System.exit(1); break;
        }
        return min;
    }
}
