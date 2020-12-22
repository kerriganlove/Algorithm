import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    static boolean[] visited = new boolean[100001];
    static int start;
    static int end;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        Queue<int []> que = new LinkedList<>();
        que.add(new int[]{start,0});
        visited[start] = true;
        while (!que.isEmpty())
        {
            int[] data = que.poll();
            int val = data[0];
            int sec = data[1];
            if ( val == end) { System.out.println(sec); break; }

            if (val-1 >= 0 && !visited[val-1])
            {
                visited[val-1] = true;
                que.add(new int[]{val-1,sec+1});
            }
            if (val+1 < 100001 && !visited[val+1])
            {
                visited[val+1] = true;
                que.add(new int[]{val+1,sec+1});
            }
            if ( 2*val < 100001 && !visited[2*val])
            {
                visited[2*val] = true;
                que.add(new int[]{2*val,sec+1});
            }
        }
    }
}
