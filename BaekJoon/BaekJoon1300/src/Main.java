import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int start = 1;
        int end = K;
        int answer = -1;
        while ( start <= end)
        {
            int count = 0;
            int mid = (start+end)/2;
            for ( int i = 1; i <= N; i++)
            {
                count+= Math.min(mid/i, N);
            }
            if ( count < K) { start = mid+1; }
            else { end = mid-1; answer = mid; }
        }
        System.out.println(answer);
    }
}
