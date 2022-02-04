import java.io.*;
import java.util.*;

public class Main
{
    static String s,t;
    static int answer = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = br.readLine();
        t = br.readLine();
        DFS(t);
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static void DFS(String str)
    {
        if ( str.equals(s))
        {
            answer = 1;
            return ;
        }
        StringBuilder sb = new StringBuilder(str);
        String a = str;
        String b = sb.reverse().toString();
        if ( a.length() >= s.length() && a.charAt(a.length()-1) == 'A')
        {
            DFS(a.substring(0,a.length()-1));
        }
        if ( b.length() >= s.length() && b.charAt(b.length()-1) == 'B')
        {
            DFS(b.substring(0,b.length()-1));
        }
    }
}
