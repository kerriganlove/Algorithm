import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] kilo = new int[N];
        int [] place = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i < N; i++)
        {
            kilo[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for ( int i = 1; i <= N; i++)
        {
            place[i] = Integer.parseInt(st.nextToken());
        }
        int min = 10001;
        long pre = 0;
        long answer = 0;
        for ( int i = 1; i <= N; i++)
        {
            min = Math.min(place[i],min);
        }
        int i = 1;
        while(i != N)
        {
            for (int j = i+1; j <= N; j++)
            {
                pre+=kilo[j-1];
                if (place[i] > place[j])
                {
                    answer+=pre*place[i];
                    i=j;
                    pre = 0;
                    break;
                }
                if ( j == N) { answer+=pre*place[i]; i=N; }
            }
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
