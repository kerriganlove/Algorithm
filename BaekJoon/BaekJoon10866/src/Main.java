import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static class ownDeque
    {
        ArrayList<Integer> list = new ArrayList<>();
        private void push_front(int x)
        {
            list.add(0,x);
        }
        private void push_back(int x)
        {
            list.add(x);
        }
        private int pop_front()
        {
            int ans = -1;
            if ( list.size() != 0)
            {
                ans = list.remove(0);
            }
            return ans;
        }
        private int pop_back()
        {
            int ans = -1;
            if ( list.size() != 0)
            {
                ans = list.remove(list.size()-1);
            }
            return ans;
        }
        private int empty()
        {
            if ( list.isEmpty()) { return 1; }
            else { return 0; }
        }
        private int size()
        {
            return list.size();
        }
        private int front()
        {
            int ans = -1;
            if ( list.size() != 0)
            {
                ans = list.get(0);
            }
            return ans;
        }
        private int back()
        {
            int ans = -1;
            if ( list.size() != 0)
            {
                ans = list.get(list.size()-1);
            }
            return ans;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ownDeque deque = new ownDeque();
        for ( int i = 0; i < N; i++)
        {
            int ans = dequeFunc(br.readLine(),deque);
            if ( ans != -2) { bw.write(ans+"\n"); }
        }
        bw.flush();
        bw.close();
    }
    public static int dequeFunc(String str, ownDeque deque)
    {
        int ans = -2;
        int x = 0;
        StringTokenizer st = new StringTokenizer(str," ");
        String com = st.nextToken();
        switch(com)
        {
            case "push_front" :
                x = Integer.parseInt(st.nextToken());
                deque.push_front(x);
                break;
            case "push_back" :
                x = Integer.parseInt(st.nextToken());
                deque.push_back(x);
                break;
            case "pop_front" :
                ans = deque.pop_front();
                break;
            case "pop_back" :
                ans = deque.pop_back();
                break;
            case "empty" :
                ans = deque.empty();
                break;
            case "size" :
                ans = deque.size();
                break;
            case "front" :
                ans = deque.front();
                break;
            case "back" :
                ans = deque.back();
                break;
        }
        return ans;
    }
}
