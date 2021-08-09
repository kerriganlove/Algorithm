import java.io.*;

public class Main
{
    static String ans = null;
    static boolean stop;
    static int N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        DFS(1,"1");
        bw.write(ans+'\n');
        bw.flush();
        bw.close();
    }
    static void DFS(int len, String s)
    {
        if ( stop)
        {
            return ;
        }
        if ( len == N)
        {
            stop = true;
            ans = s;
            return ;
        }
        for ( int i = 1; i <= 3; i++)
        {
            if ( isOK(s+i) )
            {
                DFS(len+1, s+i);
            }
        }
    }
    static boolean isOK(String s)
    {
        boolean ok = false;
        int len = s.length();
        for ( int i = 1; i <= len / 2; i++)
        {
            String st = s.substring(len-i-i,len-i);
            String end = s.substring(len-i,len);
            if ( !st.equals(end))
            {
                ok = true;
            }
            else {
                return false;
            }
        }
        return ok;
    }
}
