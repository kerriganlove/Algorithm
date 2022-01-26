import java.io.*;
import java.util.Stack;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String org = br.readLine();
        String del = br.readLine();
        int count = 0;
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < org.length(); i++)
        {
            int start = del.length()-1;
            boolean checked = false;
            if ( org.charAt(i) == del.charAt(del.length()-1))
            {
                if ( del.length() == 1) { continue; }
                int stk_start = 1;
                for ( int j = del.length()-2; j >= 0; j--)
                {
                    if ( stk.size() < del.length()-1) { continue; }
                    if (del.charAt(j) != stk.get(stk.size()-stk_start))
                    {
                        checked = false;
                        break;
                    }
                    else
                    {
                        checked = true;
                        stk_start++;
                    }
                }
                count = del.length()-1;
                if ( checked ) {
                    while (count > 0) {
                        stk.pop();
                        count--;
                    }
                }
                else
                {
                    stk.add(org.charAt(i));
                }
            }
            else
            {
                stk.add(org.charAt(i));
            }
        }
        while ( !stk.isEmpty())
        {
            sb.append(stk.pop());
        }
        String answer = (sb.length() == 0) ? "FRULA" : sb.reverse().toString();
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}