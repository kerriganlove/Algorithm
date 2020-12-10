import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    static int N;
    static int K;
    static int[] list;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        System.out.println(BinarySearch(list[0],list[N-1]));
    }
    public static int BinarySearch(int start, int end)
    {
        int mid;
        long sum;
        while ( start <= end)
        {
            sum = 0;
            mid = (start+end) / 2;
            for ( int i = 0; i < N; i++)
            {
                sum += Math.max(list[i]-mid,0);
            }
            if ( sum >= K )
            {
                start = mid + 1;
            }
            else { end = mid - 1; }
        }
        return end;
    }
}
