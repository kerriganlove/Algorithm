import java.util.*;
import java.io.*;

public class Main
{
    static int [] numList = new int[200001];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] list = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < n; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int answer = 0;
        int max = -1;
        while ( end != n)
        {
            int num = list[end];
            if (numList[num] >= k)
            {
                max = Math.max(answer,max);
                numList[list[start]]--;
                start++;
                answer--;
            }
            else
            {
                numList[num]++;
                end++;
                answer++;
            }
        }
        max = Math.max(answer,max);
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
}
