import javax.print.attribute.IntegerSyntax;
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for ( int i = 0; i < N; i++)
        {
            que.add(Integer.parseInt(br.readLine()));
        }
        while(que.size() != 1)
        {
            int x = que.poll();
            int y = que.poll();
            sum += x+y;
            que.add(x+y);
        }
        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}
