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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] ans = new int[M];
        for ( int i = 0; i < M; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            if ( Arrays.binarySearch(list,num) < 0)
            {
                ans[i] = 0;
            }
            else { ans[i] = 1; }
        }
        for ( int i : ans)
        {
            sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
}
