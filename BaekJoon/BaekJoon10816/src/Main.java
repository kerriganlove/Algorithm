import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int [] list = new int[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < N; i++)
        {
            int num = Integer.parseInt(st.nextToken()) + 10000000;
            list[num]++;
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < M; i++)
        {
            int ans = Integer.parseInt(st.nextToken()) + 10000000;
            bw.write(list[ans]+" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
