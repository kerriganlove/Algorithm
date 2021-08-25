import java.io.*;
import java.util.*;

public class Main
{
    static PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for ( int i = 0; i < N; i++)
        {
            int num = Integer.parseInt(br.readLine());
            int ans = printNum(num);
            if (ans != -1) {
                bw.write(ans + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
    static int printNum(int num)
    {
        if ( num == 0)
        {
            if (que.size() == 0)
            {
                return 0;
            }
            else
            {
                return que.poll();
            }
        }
        else
        {
            que.add(num);
            return -1;
        }
    }
}

