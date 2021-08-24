import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int answer = 0;
        if ( A == B && A >= V ) { answer = 1; }
        else {
            answer = (V-B)/(A-B);
            if ( (V-B)%(A-B) != 0)
            {
                answer++;
            }
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
