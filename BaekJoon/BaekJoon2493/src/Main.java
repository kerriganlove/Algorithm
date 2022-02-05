import java.io.*;
import java.util.*;

public class Main
{
    static int n;
    static int [] list;
    static int [] answer;
    static Stack<Integer> stk;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        list = new int[n+1];
        answer = new int[n+1];
        stk = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for ( int i = 1; i <= n; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int max = list[n];
        stk.add(n);
        for ( int i = n-1; i >= 1; i--)
        {
            if ( list[stk.peek()] < list[i])
            {
                while(list[stk.peek()] < list[i])
                {
                    answer[stk.pop()] = i;
                    if ( stk.isEmpty()) { break; }
                }
            }
            stk.add(i);
        }
        for ( int i = 1; i <= n; i++)
        {
            bw.write(answer[i]+" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
