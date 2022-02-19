import java.io.*;
import java.util.*;

public class Main
{
    static StringBuilder sb;
    static HashSet<Integer> hs;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        hs = new HashSet<>();
        sb = new StringBuilder();
        for ( int i = 0; i < n; i++)
        {
            solve(br.readLine());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void solve(String s)
    {
        StringTokenizer st = new StringTokenizer(s," ");
        String comm = st.nextToken();
        int num = 0;
        if ( st.hasMoreTokens() ) {
            num = Integer.parseInt(st.nextToken());
        }
        switch(comm)
        {
            case "add" :
                hs.add(num);
                break;
            case "remove":
                hs.remove(num);
                break;
            case "check":
                if (hs.contains(num)) { sb.append("1\n");}
                else { sb.append("0\n"); }
                break;
            case "toggle" :
                if ( hs.contains(num)) {hs.remove(num);}
                else { hs.add(num); }
                break;
            case "all" :
                hs.clear();
                for ( int i = 1; i <= 20; i++)
                {
                    hs.add(i);
                }
                break;
            case "empty" :
                hs.clear();
                break;
        }
    }
}
