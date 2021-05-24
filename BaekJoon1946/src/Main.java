import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while ( T > 0)
        {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            ArrayList<int []> list = new ArrayList<>();
            for ( int i = 0; i < N; i++)
            {
                st = new StringTokenizer(br.readLine()," ");
                int [] grade = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
                list.add(grade);
            }
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if ( o1[0] < o2[0]) { return -1; }
                    return 1;
                }
            });
            Stack<int []> stk = new Stack<>();
            stk.add(list.get(0));
            for ( int i = 1; i < N; i++)
            {
                if ( stk.peek()[1] > list.get(i)[1])
                {
                    stk.add(list.get(i));
                }
            }
            sb.append(stk.size()+"\n");
            T--;
        }
        System.out.print(sb.toString());
    }
}
