import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] list = new int[1000001];
        for ( int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            list[x] = g;
        }
        int max = 0;
        int answer = -1;
        int max_len = K*2;
        int start = 0;
        for ( int i = 0; i < list.length; i++)
        {
            max += list[i];
            if ( i >= max_len) {
                answer = Math.max(max, answer);
                max -= list[start];
                start++;
            }
        }
        System.out.println(answer == -1? max : answer);
    }
}
