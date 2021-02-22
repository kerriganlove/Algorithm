import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main
{
    static class Info
    {
        int key;
        int count;

        public Info(int key, int count) {
            this.key = key;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Info> stk = new Stack<>();
        long answer = 0;
        for ( int i = 0; i < N; i++)
        {
            int len = Integer.parseInt(br.readLine());
            Info in = new Info(len,1);
            while(!stk.isEmpty())
            {
                if ( stk.peek().key <= len)
                {
                    answer += stk.peek().count;
                    if ( stk.peek().key == len)
                    {
                        in.count += stk.peek().count;
                    }
                    stk.pop();
                }
                else
                {
                    break;
                }
            }
            if (!stk.empty())
            {
                answer++;
            }
            stk.push(in);
        }
        System.out.println(answer);
    }
}
