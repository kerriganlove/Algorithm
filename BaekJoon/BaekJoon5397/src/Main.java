import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while ( N > 0)
        {
            StringBuilder sb2 = new StringBuilder();
            String s = br.readLine();
            Stack<Character> stk = new Stack<>();
            Stack<Character> save = new Stack<>();
            for ( int i = 0; i < s.length(); i++)
            {
                switch(s.charAt(i))
                {
                    case '<' : if (!stk.empty()) { save.push(stk.pop()); } break;
                    case '>' : if (!save.empty()) { stk.push(save.pop()); } break;
                    case '-' : if (!stk.empty()) { stk.pop(); } break;
                    default : stk.push(s.charAt(i));
                }
            }
            while(!save.empty()) { stk.push(save.pop()); }
            while(!stk.empty()) { sb2.append(stk.pop()); }
            sb.append(sb2.reverse().append("\n"));
            N--;
        }
        System.out.print(sb.toString());
    }
}
