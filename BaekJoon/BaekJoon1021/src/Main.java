import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        LinkedList<Integer> dq = new LinkedList<>();
        for ( int i = 1; i <= n; i++)
        {
            dq.add(i);
        }
        int [] list = new int[c];
        st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < c; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for ( int i = 0; i < c; i++)
        {
            int target = dq.indexOf(list[i]);
            int half;
            if ( dq.size() % 2 == 0)
            {
                half = (dq.size()/2)-1;
            }
            else
            {
                half = (dq.size()/2);
            }
            if ( target <= half)
            {
                for ( int j = 0; j < target; j++)
                {
                    int temp = dq.pollFirst();
                    dq.addLast(temp);
                    count++;
                }
            }
            else
            {
                for ( int j = 0; j < dq.size()-target; j++)
                {
                    int temp = dq.pollLast();
                    dq.addFirst(temp);
                    count++;
                }
            }
            dq.pollFirst();
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}
