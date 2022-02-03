import java.io.*;
import java.util.*;

public class Main
{
    static int [] map;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[m];
        st = new StringTokenizer(br.readLine()," ");
        int sum = 0;
        for ( int j = 0; j < m; j++)
        {
            map[j] = Integer.parseInt(st.nextToken());
            sum += map[j];
        }
        int answer = 0;
        int white = (n*m)-sum;
        int start = 0;
        int count = 1;
        if ( m == 0 && m == 1) { answer = 0; }
        else
        {
            for ( int i = 0; i < m; i++)
            {
                int l_max = -1;
                int r_max = -1;
                for ( int j = i; j >= 0; j--)
                {
                    l_max = Math.max(map[j],l_max);
                }
                for ( int j = i; j < m; j++)
                {
                    r_max = Math.max(map[j],r_max);
                }
                int max = Math.min(l_max, r_max);
                answer += max-map[i];
            }
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
