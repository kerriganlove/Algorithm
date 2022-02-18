import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while ( t > 0)
        {
            int n = Integer.parseInt(br.readLine());
            long answer = 0;
            int [] list = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for ( int i = 0; i < n; i++)
            {
                list[i] = Integer.parseInt(st.nextToken());
            }
            int max = list[n-1];
            for ( int i = n-2; i >= 0; i--)
            {
                if ( max <= list[i]) { max = list[i]; }
                else
                {
                    answer+=(max-list[i]);
                }
            }
            sb.append(answer+"\n");
            t--;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
