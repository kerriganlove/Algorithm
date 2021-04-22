import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] answer = new int[N];
        Stack<Integer> stk = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        for ( int i = 0; i < N; i++)
        {
            while(!stk.empty() && answer[i] > answer[stk.peek()])
            {
                answer[stk.pop()] = answer[i];
            }
            stk.push(i);
        }
        while(!stk.empty())
        {
            answer[stk.pop()] = -1;
        }
        for (int i : answer)
        {
            sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
}
