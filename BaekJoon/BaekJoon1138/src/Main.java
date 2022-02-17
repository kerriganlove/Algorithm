import java.io.*;
import java.util.*;

public class Main
{
    static int [] ex;
    static int n;
    static ArrayList<Integer> ans;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        ex = new int[n+1];
        ans = new ArrayList<>();
        for ( int i = 1; i <= n; i++)
        {
            ex[i] = Integer.parseInt(st.nextToken());
        }
        for ( int i = n; i >= 1; i--)
        {
            ans.add(ex[i],i);
        }
        StringBuilder sb = new StringBuilder();
        for ( int i : ans)
        {
            sb.append(i+" ");
        }
        bw.write(sb.toString()+"\n");
        bw.flush();
        bw.close();
    }
}
