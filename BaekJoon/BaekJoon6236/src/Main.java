import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static int N,M;
    static int [] list;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int sum = 0;
        int answer = 0;
        list = new int[N];
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
            sum+=list[i];
        }
        int start = 1;
        int end = sum;
        int mid = 0;
        while ( start <= end)
        {
            mid = (start+end)/2;
            if ( precise(mid) )
            {
                answer = mid;
                end = mid - 1;
            }
            else { start = mid + 1; }
        }
        System.out.println(answer);
    }
    static boolean precise(int num)
    {
        int sum = num;
        int cnt = 1;
        for ( int i = 0; i < N; i++)
        {
            if ( num < list[i]) { return false; }
            if ( sum - list[i] < 0) { sum = num; cnt++; }
            sum-=list[i];
        }
        return M >= cnt;
    }
}
