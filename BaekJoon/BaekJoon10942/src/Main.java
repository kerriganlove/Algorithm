import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static int N, M;
    static int [] list;
    static boolean [][] ok = new boolean[2001][2001];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        list = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for ( int i = 1; i <= N; i++)
        {
           list[i] = Integer.parseInt(st.nextToken());
        }
        Palindrome();
        M = Integer.parseInt(br.readLine());
        for ( int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(((ok[start][end]) ? 1 : 0) +"\n");
        }
        System.out.print(sb.toString());
    }
    static void Palindrome()
    {
        for ( int i = 1; i <= N; i++)
        {
            ok[i][i] = true;
        }
        for ( int i = 1; i < N; i++)
        {
            if ( list[i] == list[i+1])
            {
                ok[i+1][i] = ok[i][i+1] = true;
            }
        }
        for ( int i = 2; i < N; i++)
        {
            for ( int j = 1; j <= N-i; j++)
            {
                if ( list[j] == list[j+i] && ok[j+1][j+i-1])
                {
                    ok[j][j+i] = true;
                }
            }
        }
    }
}
