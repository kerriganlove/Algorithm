import java.io.*;
import java.util.*;

public class Main
{
    static int n,t;
    static int [] list;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        list = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < n; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = 1000000000-2;
        int mid = 0;
        while ( s < e)
        {
            mid = (s+e)/2;
            if ( isOK(mid))
            {
                e = mid;
            }
            else
            {
                s = mid+1;
            }
        }
        for ( int i = 0; i < n-1; i++)
        {
            if ( list[i+1] - list[i] > e)
            {
                list[i+1] = list[i] + e;
            }
        }
        for ( int i = n-1; i > 0; i--)
        {
            if ( list[i-1] - list[i] > e )
            {
                list[i-1] = list[i] + e;
            }
        }
        for(int i : list)
        {
            bw.write(i+" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
    static boolean isOK(int mid)
    {
        long cnt = 0;
        int [] copy = new int[n];
        System.arraycopy(list,0,copy,0,list.length);
        for ( int i = 0; i < n-1; i++) {
            if (copy[i + 1] - copy[i] > mid)
            {
                cnt += copy[i+1] - (copy[i]+mid);
                copy[i+1] = copy[i] + mid;
            }
        }
        for ( int i = n-1; i > 0; i--)
        {
            if ( copy[i-1] - copy[i] > mid)
            {
                cnt += copy[i-1] - (copy[i]+mid);
                copy[i-1] = copy[i] + mid;
            }
        }
        return cnt <= t;
    }
}
