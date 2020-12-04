import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static int [] list;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long []answer = new long[T];
        for (int i = 0; i < T; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            list = new int[N];
            for ( int j = 0; j < N; j++)
            {
                list[j] = Integer.parseInt(st.nextToken());
            }
            for ( int k = 0; k < N; k++)
            {
                for (int l = k+1; l < N; l++)
                {
                    answer[i] += GCD(list[k],list[l]);
                }
            }
        }
        for (long i : answer)
        {
            System.out.println(i);
        }
    }
    public static int GCD(int a, int b)
    {
        if ( b == 0) return a;
        else return GCD(b,a%b);
    }
}
