import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();
        int count = 0;
        for ( int i = 0; i < N; i++)
        {
            stk.push(Integer.parseInt(br.readLine()));
        }
        int max = stk.pop();
        count++;
        while(!stk.empty())
        {
            int cur = stk.pop();
            if ( max < cur )
            {
                max = cur; count++;
            }
        }
        System.out.println(count);
    }
}
