import java.io.*;
import java.util.*;

public class Main
{
    static HashSet<String> ts;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ts = new HashSet<>();
        for ( int i = 0; i < n; i++)
        {
            ts.add(br.readLine());
        }
        int answer = n;
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine(),",");
            while (st.hasMoreTokens())
            {
                String s = st.nextToken();
                if ( ts.contains(s))
                {
                    ts.remove(s);
                    answer--;
                }
            }
            sb.append(answer+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
