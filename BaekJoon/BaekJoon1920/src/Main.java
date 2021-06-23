import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] list = new int[N];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < K; i++)
        {
            int bool = Integer.parseInt(st.nextToken());
            if ( Arrays.binarySearch(list,bool) >= 0) { sb.append("1\n"); }
            else { sb.append("0\n"); }
        }
        System.out.print(sb.toString());
    }
}
