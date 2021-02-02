import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for ( int j = 1; j <=K; j++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int max = 0;
            Integer [] list = new Integer[N];
            for ( int i = 0; i < N; i++)
            {
                list[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(list, Collections.reverseOrder());
            for ( int i = 0; i < N-1; i++)
            {
                max = Math.max(max,list[i]-list[i+1]);
            }
            sb.append("Class "+j+"\n"+"Max "+list[0]+", Min "+list[N-1]+", Largest gap "+max+"\n");
        }
        System.out.print(sb.toString());
    }
}
