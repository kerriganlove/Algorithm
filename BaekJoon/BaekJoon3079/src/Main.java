import java.util.*;
import java.io.*;

public class Main
{
    static int n,m;
    static int [] list;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n];
        for ( int i = 0; i < n; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        for ( int i : list)
        {
            max = Math.max(max,i);
        }
        long s = 1;
        long e = (long)max*m;
        long ans = 0;
        while( s <= e)
        {
            long mid = (s+e)/2;
            if(solve(mid))
            {
                ans = mid;
                e = mid-1;
            }
            else
            {
                s = mid+1;
            }
        }
        if ( ans == 0) { ans = e;}
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
    }
    static boolean solve(long mid)
    {
        long ans = 0;
        for ( int i = 0; i < list.length; i++)
        {
            ans+= (mid/list[i]);
        }
        if ( ans >= m)
        {
            return true;
        }
        return false;
    }
}
