import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static boolean[] list = new boolean[1000001];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int cnt = 0;
        int len = (int)(max-min+1);
        isSquare(min,max);
        for ( int i = 0; i < len; i++)
        {
            if (!list[i])
            {
                cnt++;
            }
        }
        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
    }
    static void isSquare(long min, long max)
    {
        for ( long i = 2; i*i <= max; i++)
        {
            long a = min / (i*i);
            if ( min % (i*i) != 0)
            {
                a++;
            }
            while(a*(i*i) <= max)
            {
                int num = (int)(a*(i*i)-min);
                list[num] = true;
                a++;
            }
        }
    }
}
