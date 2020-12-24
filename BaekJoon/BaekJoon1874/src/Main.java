import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main
{
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] save = new int[N];
        int s = 0;
        for (int i = 0; i < N; i++) {
            save[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; i++)
        {
            stk.push(i);
            list.add("+");
            while (!stk.empty() && save[s] == stk.peek())
            {
                stk.pop();
                list.add("-");
                s++;
            }
        }
        if (!stk.empty()) { System.out.println("NO"); }
        else {
            for (String st : list) {
                System.out.println(st);
            }
        }
    }
}
