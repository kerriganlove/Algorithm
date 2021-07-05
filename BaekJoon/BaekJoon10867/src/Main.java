import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        TreeSet<Integer> ts = new TreeSet<>();
        for ( int i = 0; i < N; i++)
        {
            ts.add(Integer.parseInt(st.nextToken()));
        }
        for ( int i : ts)
        {
            bw.write(i+" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
