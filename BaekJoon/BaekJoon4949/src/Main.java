import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main
{
    static Stack<Character> stk;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> answers = new ArrayList<>();
        while(true)
        {
            stk = new Stack<>();
            String s = br.readLine();
            if ( s.equals(".")) { break; }
            answers.add(find(s)? "yes" : "no");
        }
        for ( String s : answers)
        {
            System.out.println(s);
        }
    }
    public static boolean find(String a)
    {
        for ( int i = 0; i < a.length(); i++) {
            switch (a.charAt(i)) {
                case '[':
                case '(':
                    stk.push(a.charAt(i));
                    break;
                case ']':
                    if (!stk.empty() && stk.peek() == '[') {
                        stk.pop();
                    }
                    else { return false; }
                    break;
                case ')':
                    if (!stk.empty() && stk.peek() == '(') {
                        stk.pop();
                    } else { return false; }
                    break;
                default:
                    break;
            }
        }
        if ( stk.empty() ) { return true; }
        else { return false; }
    }
}
