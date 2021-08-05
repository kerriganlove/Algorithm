import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static int [] list = new int[1000001];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        isPrimeNumber();
        for ( int i = s; i <= e; i++)
        {
            if ( list[i] != 0)
            {
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static void isPrimeNumber()
    {
        for ( int i = 2; i <= 1000000; i++)
        {
            list[i] = i;
        }
        for ( int i = 2; i <= 1000000; i++)
        {
            if ( list[i] == 0) { continue; }
            for ( int j = i+i; j <= 1000000; j+=i)
            {
                if ( list[j] == 0) { continue; }
                else { list[j] = 0; }
            }
        }
    }
}
