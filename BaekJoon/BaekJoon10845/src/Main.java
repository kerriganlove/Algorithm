import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    public static class ownQue
    {
        ArrayList<Integer> list = new ArrayList<>();
        private void push(int x)
        {
            list.add(x);
        }
        private int pop()
        {
            int ans = -1;
            if ( list.size() != 0)
            {
                ans = list.remove(0);
            }
            return ans;
        }
        private int size()
        {
            return list.size();
        }
        private int empty()
        {
            if (list.isEmpty()) { return 1; }
            else { return 0; }
        }
        private int front() {
            int ans = -1;
            if (list.size() != 0)
            {
                ans = list.get(0);
            }
            return ans;
        }
        private int back() {
            int ans = -1;
            if (list.size() != 0) {
                ans = list.get(list.size()-1);
            }
            return ans;
        }
    }
    public static void main(String[] args) throws IOException
    {
        ownQue que = new ownQue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for ( int i = 0; i < N; i++)
        {
            int num = queFunc(br.readLine(), que);
            if (num != -2)
            {
                bw.write(num+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static int queFunc(String str, ownQue que) throws IOException
    {
        int ans = -2;
        StringTokenizer st = new StringTokenizer(str," ");
        String com = st.nextToken();
        switch(com)
        {
            case "push" :
                int num = Integer.parseInt(st.nextToken());
                que.push(num);
                break;
            case "empty" :
                ans = que.empty();
                break;
            case "pop" :
                ans = que.pop();
                break;
            case "size" :
                ans = que.size();
                break;
            case "front" :
                ans = que.front();
                break;
            case "back" :
                ans = que.back();
                break;
        }
        return ans;
    }
}
