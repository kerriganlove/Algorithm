import java.io.*;
import java.util.*;

public class Main
{
    static int n;
    static int [] org;
    static int [] ans;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String start = br.readLine();
        org = new int[n];
        ans = new int[n];
        for ( int i = 0; i < start.length(); i++)
        {
            org[i] = Integer.parseInt(String.valueOf(start.charAt(i)));
        }
        String answer = br.readLine();
        for ( int i = 0; i < answer.length(); i++)
        {
            ans[i] = Integer.parseInt(String.valueOf(answer.charAt(i)));
        }
        int ans1 = func(0);
        int ans2 = func(1);
        int temp = Math.min(ans1,ans2);
        if ( temp == INF ) { temp = -1; }
        bw.write(temp+"\n");
        bw.flush();
        bw.close();
    }
    static int func(int idx)
    {
        int answer = INF;
        int count = 0;
        int [] temp = Arrays.copyOf(org,org.length);
        if ( idx == 0)
        {
            temp[0] = (temp[0] == 0) ? 1 : 0;
            temp[1] = (temp[1] == 0) ? 1 : 0;
            count++;
        }
        for ( int i = 1; i < n; i++)
        {
            if ( temp[i-1] != ans[i-1]) {
                if (i == n - 1) {
                    temp[n - 2] = (temp[n - 2] == 0) ? 1 : 0;
                    temp[n - 1] = (temp[n - 1] == 0) ? 1 : 0;
                } else {
                    temp[i - 1] = (temp[i - 1] == 0) ? 1 : 0;
                    temp[i] = (temp[i] == 0) ? 1 : 0;
                    temp[i + 1] = (temp[i + 1] == 0) ? 1 : 0;
                }
                count++;
            }
        }
        if ( Arrays.compare(temp,ans) == 0) { answer = Math.min(answer,count); }
        return answer;
    }
}