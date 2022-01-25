import java.io.*;
import java.util.Stack;

public class Main
{
    static Stack<Character> l_stk = new Stack<>();
    static Stack<Character> r_stk = new Stack<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String t = br.readLine();
        int start = 0;
        int end = t.length()-1;
        while(start <= end)
        {
            boolean del;
            while (start <= end)
            {
                del = true;
                l_stk.push(t.charAt(start++));
                if ( l_stk.size() >= a.length())
                {
                    for ( int i = 0; i < a.length(); i++)
                    {
                        if ( a.charAt(i) != l_stk.get(l_stk.size()-(a.length()-i)))
                        {
                            del = false;
                            break;
                        }
                    }
                    if ( del )
                    {
                        for ( int i = 0; i < a.length(); i++)
                        {
                            l_stk.pop();
                        }
                        break;
                    }
                }
            }
            while(start <= end)
            {
                del = true;
                r_stk.push(t.charAt(end--));
                if ( r_stk.size() >= a.length())
                {
                    for ( int i = 0; i < a.length(); i++)
                    {
                        if ( a.charAt(i) != r_stk.get(r_stk.size()-(i+1)))
                        {
                            del = false;
                            break;
                        }
                    }
                    if ( del )
                    {
                        for ( int i = 0; i < a.length(); i++)
                        {
                            r_stk.pop();
                        }
                        break;
                    }
                }
            }
        }
        while(!l_stk.isEmpty())
        {
            r_stk.push(l_stk.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!r_stk.isEmpty())
        {
            sb.append(r_stk.pop());
        }
        while(true)
        {
            int index = sb.indexOf(a);
            if ( index < 0) break;
            sb.delete(index, index+a.length());
        }
        bw.write(sb.toString()+"\n");
        bw.flush();
        bw.close();
    }
}