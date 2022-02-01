import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        for ( int i = 1; i <= n; i++)
        {
            dq.add(i);
        }
        while(dq.size() != 1)
        {
            dq.poll();
            dq.addLast(dq.poll());
        }
        bw.write(dq.poll()+"\n");
        bw.flush();
        bw.close();
    }
}
