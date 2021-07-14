import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static int count = 0;
    static boolean[] checked;
    static int [] list;
    static int S;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        list = new int[N];
        checked = new boolean[N];
        st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        for ( int i = 1; i <= N; i++)
        {
            Combination(0,0,i);
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void Combination(int idx, int s, int e)
    {
        if ( s == e)
        {
            int sum = 0;
            for ( int i = 0; i < list.length; i++)
            {
                if ( checked[i]) {
                    sum+= list[i];
                }
            }
            if (sum == S) { count++; }
            return ;
        }
        for ( int i = idx; i < list.length; i++)
        {
            if ( checked[i]) { continue; }
            checked[i] = true;
            Combination(i,s+1,e);
            checked[i] = false;
        }
    }
}
