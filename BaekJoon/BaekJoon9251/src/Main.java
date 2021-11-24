import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String b = br.readLine();
        int [][] dp = new int[a.length()+1][b.length()+1];
        for ( int i = 1; i <= a.length(); i++)
        {
            char ac = a.charAt(i-1);
            for ( int j = 1; j <= b.length(); j++)
            {
                char bc = b.charAt(j-1);
                if ( ac == bc)
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        bw.write(dp[a.length()][b.length()]+"\n");
        bw.flush();
        bw.close();
    }
}
