import java.io.*;
import java.util.*;

public class Main
{
    static int start;
    static int end;
    static int [] distance;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        distance = new int[100001];
        Arrays.fill(distance,INF);
        Queue<Integer> que = new LinkedList<>();
        distance[start] = 0;
        que.add(start);
        while (!que.isEmpty())
        {
            int val = que.poll();
            if ( val == end)
            {
                bw.write(distance[val]+"\n");
                break;
            }
            if (val-1 >= 0)
            {
                if ( distance[val-1] > distance[val])
                {
                    distance[val-1] = distance[val]+1;
                    que.add(val-1);
                }
            }
            if (val+1 < 100001)
            {
                if ( distance[val+1] > distance[val])
                {
                    distance[val+1] = distance[val]+1;
                    que.add(val+1);
                }
            }
            if ( 2*val < 100001)
            {
                if ( distance[2*val] > distance[val])
                {
                    distance[2*val] = distance[val];
                    que.add(2*val);
                }
            }
        }
        bw.flush();
        bw.close();
    }
}