import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> answer = new Stack<>();
        int size = s.length();
        for ( int i = 0; i < size; i++)
        {
            answer.add(s.charAt(i));
        }
        Deque<Character> list = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for ( int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken())
            {
                case "L" : if(!answer.empty()) {list.addFirst(answer.pop());} break;
                case "D" : if(answer.size() < size) {answer.add(list.pollFirst());} break;
                case "B" : if(!answer.empty()) {answer.pop(); size--;} break;
                case "P" :
                    String save = st.nextToken();
                    for ( char a : save.toCharArray())
                    {
                        answer.push(a);
                        size++;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!answer.isEmpty())
        {
            sb.append(answer.pop());
        }
        sb.reverse();
        while(!list.isEmpty())
        {
            sb.append(list.pollFirst());
        }
        System.out.println(sb.toString());
    }
}
