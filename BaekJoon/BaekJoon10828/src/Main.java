import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static class ownStack{
        ArrayList<Integer> list = new ArrayList<>();
        private void push(int x)
        {
            list.add(x);
        }
        private int pop()
        {
           int ans = -1;
           if ( list.size() != 0) {
               ans = list.remove(list.size() - 1);
           }
           return ans;
        }
        private int size()
        {
            return list.size();
        }
        private int empty()
        {
            if ( list.isEmpty() ) { return 1; }
            else { return 0; }
        }
        private int top()
        {
            int ans = -1;
            if ( list.size() != 0) {
                ans = list.get(list.size()-1);
            }
            return ans;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ownStack stk = new ownStack();
        for ( int i = 0; i < N; i++)
        {
            stkFunc(br.readLine(), stk);
        }
    }
    public static void stkFunc(String fun,ownStack stk)
    {
        StringTokenizer st = new StringTokenizer(fun," ");
        String com = st.nextToken();
        switch(com) {
            case "push":
                int num = Integer.parseInt(st.nextToken());
                stk.push(num);
                break;
            case "top":
                System.out.println(stk.top());
                break;
            case "size":
                System.out.println(stk.size());
                break;
            case "empty" :
                System.out.println(stk.empty());
                break;
            case "pop" :
                System.out.println(stk.pop());
                break;
        }
    }
}
