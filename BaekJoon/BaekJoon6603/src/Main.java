import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    static int [] list;
    static boolean [] checked;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true)
        {
            String s = br.readLine();
            if ( s.equals("0"))
            {
                break;
            }
            StringTokenizer st = new StringTokenizer(s," ");
            int N = Integer.parseInt(st.nextToken());
            list = new int[N];
            checked = new boolean[N];
            for ( int i = 0; i < N; i++)
            {
                list[i] = Integer.parseInt(st.nextToken());
            }
            Combination(0,bw,0,6,N);
            bw.write("\n");
            bw.flush();
        }
        bw.close();
    }
    public static void Combination(int idx, BufferedWriter bw, int s, int e,int N) throws IOException
    {
        if ( s == e)
        {
            for ( int i = 0; i < N; i++)
            {
                if ( checked[i] ) {bw.write(list[i]+" "); }
            }
            bw.write("\n");
            return ;
        }
        for ( int i = idx; i < N; i++)
        {
            if ( checked[i] ) { continue; }
            checked[i] = true;
            Combination(i,bw, s+1, e, N);
            checked[i] = false;
        }
    }
}
