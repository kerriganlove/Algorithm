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
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        for ( int i = 0; i < N; i++)
        {
            int x = Integer.parseInt(br.readLine());
            if ( min_heap.size() == max_heap.size()) { max_heap.add(x); }
            else { min_heap.add(x); }
            if ( !min_heap.isEmpty() && !max_heap.isEmpty())
            {
                if ( min_heap.peek() < max_heap.peek())
                {
                    int temp = min_heap.poll();
                    min_heap.add(max_heap.poll());
                    max_heap.add(temp);
                }
            }
            sb.append(max_heap.peek()+"\n");
        }
        System.out.print(sb.toString());
    }
}
