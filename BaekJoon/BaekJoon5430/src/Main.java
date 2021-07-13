import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for ( int i = 0; i < T; i++)
        {
            Deque<Integer> deque = new LinkedList<>();
            boolean point = false;
            boolean err = false;
            String com = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            String [] num = temp.substring(1,temp.length()-1).split(",");
            for ( int j = 0; j < N; j++)
            {
                deque.add(Integer.parseInt(num[j]));
            }
            for ( int j = 0; j < com.length(); j++)
            {
                switch(com.charAt(j))
                {
                    case 'R' :
                        point = !point;
                        break;
                    case 'D' :
                        if (deque.isEmpty()) {
                            err = true;
                            break;
                        }
                        if (!point)
                        {
                            deque.pollFirst();
                        }
                        else
                        {
                            deque.pollLast();
                        }
                        break;
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            while (!deque.isEmpty())
            {
                if (!point)
                {
                    list.add(deque.pollFirst());
                }
                else
                {
                    list.add(deque.pollLast());
                }
            }
            if ( !err ) {
                StringBuilder sb = new StringBuilder();
                int count = 0;
                sb.append("[");
                for ( int ans : list)
                {
                    if ( count != list.size()-1)
                    {
                        sb.append(ans+",");
                    }
                    else
                    {
                        sb.append(ans);
                    }
                    count++;
                }
                sb.append("]");
                bw.write(sb.toString()+"\n");
            }
            else
            {
                bw.write("error\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
