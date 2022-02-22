import java.util.*;
import java.io.*;

public class Main
{
    static boolean [] visited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int [] list = new int[n];
        visited = new boolean[100001];
        for ( int i = 0; i < n; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        long answer = 0;
        int end = 0;
        for ( int i = 0; i < n; i++)
        {
            while ( end < n )
            {
                if (visited[list[end]]) { break; }
                visited[list[end]] = true;
                end++;
            }
            answer+=(end-i);
            visited[list[i]] = false;
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
