import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long ans = 0;
    static int K;
    static int N;
    static long[] list;
    public static void BinarySearch(long start, long end)
    {
        int x = 0;
        if ( start > end) { return; }
        long mid = (start+end) / 2;
        for ( int i = 1; i < K+1; i++)
        {
            x += (list[i])/mid;
        }
        if ( x >= N) { ans = Math.max(ans,mid); BinarySearch(mid+1,end); }
        else if ( x < N ) { BinarySearch(1,mid-1); }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s," ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        list = new long[K+1];
        for ( int i = 1; i < K+1; i++)
        {
            list[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(list);
        BinarySearch(1,list[K]);
        System.out.println(ans);
    }
}
