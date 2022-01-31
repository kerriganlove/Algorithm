import java.io.*;
import java.util.*;

public class Main
{
    static int [] num;
    static TreeMap<Integer,Integer> hs;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        num = new int[n+1];
        hs = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for ( int i = 1; i <= n; i++)
        {
           num[i] = Integer.parseInt(st.nextToken());
           hs.put(num[i],i);
        }
        int answer = 0;
        for ( int i = 1; i <= n; i++)
        {
            for ( int j = i+1; j <= n; j++)
            {
                int ans = num[i] + num[j];
                if ( hs.containsKey(ans))
                {
                    for ( int k = 0; k < hs.get(ans).)
                }
            }
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
