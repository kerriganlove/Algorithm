import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> st = new Stack<>();
        int temp = 1;
        int answer = 0;
        boolean pan = false;
        for ( int i = 0; i < s.length(); i++)
        {
            switch(s.charAt(i)){
                case '[' : temp *= 3; st.add(s.charAt(i)); break;
                case '(' : temp *= 2; st.add(s.charAt(i)); break;
                case ']' : if (!st.empty()) {char a = st.pop();
                if ( a == '[' ) { if (s.charAt(i-1) == '['){answer += temp;} temp /= 3; }
                else {pan = true; }}
                else { pan = true; }
                break;
                case ')' : if (!st.empty()) {char b = st.pop();
                if ( b == '(' ) { if (s.charAt(i-1) == '(') { answer += temp; }temp /= 2; }
                else {pan = true; } }
                else { pan = true; }
                break;
            }
        }
        if (!st.empty()) { pan = true; }
        answer = (pan) ? 0 : answer;
        System.out.println(answer);
    }
}