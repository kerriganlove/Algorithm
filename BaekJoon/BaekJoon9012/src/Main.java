import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for ( int i = 0; i < T; i++)
        {
            String s = br.readLine();
            bw.write((Func(s) ? "YES" : "NO") + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static boolean Func(String s)
    {
        Stack<Character> stk = new Stack<>();
        for ( int i = 0; i < s.length(); i++)
        {
            switch(s.charAt(i))
            {
                case '(' :
                    stk.push('(');
                    break;
                case ')' :
                    if ( stk.isEmpty()) { return false; }
                    stk.pop(); break;
            }
        }
        if ( !stk.isEmpty()) { return false; }
        else { return true; }
    }
}
