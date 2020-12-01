import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int [] list = new int[N];
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int start = 1;
        int end = list[N-1]-list[0];
        int answer = 0;
        int distance;
        while ( start <= end)
        {
            int mid = (start+end)/2;
            int first = list[0];
            int count = 1;

            for ( int i = 1; i < N; i++)
            {
                distance = list[i] - first;
                if ( mid <= distance)
                {
                    count++;
                    first = list[i];
                }
            }
            if ( count >= C)
            {
                answer = mid;
                start = mid + 1;
            }
            else { end = mid -1; }
        }
        System.out.println(answer);
    }
}
