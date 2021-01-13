import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        for ( int i = 1; i <= N; i++)
        {
            que.add(i);
        }
        int count = 0;
        while(count != N)
        {
            int temp;
            for ( int j = 0; j < K-1; j++)
            {
                temp = que.peek();
                que.poll();
                que.add(temp);
            }
            count++;
            if ( count != N) { sb.append(que.poll()+ ", "); } else { sb.append(que.poll() + ">"); }
        }
        System.out.println(sb.toString());
    }
}
