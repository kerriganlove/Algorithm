import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] list = new int[N];
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        while(K != 0)
        {
            for ( int i = N-1; i >= 0; i--)
            {
                if ( list[i] <= K )
                {
                    K-=list[i]; count++; break;
                }
            }
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}
