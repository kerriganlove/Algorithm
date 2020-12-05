import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeSet<Integer> nA = new TreeSet<>();
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++)
        {
            nA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine()," ");
        for( int j = 0; j < M; j++)
        {
            int num = Integer.parseInt(st.nextToken());
            if ( nA.contains(num) )
            {
                nA.remove(num);
            }
        }
        System.out.println(nA.size());
        for (int a : nA)
        {
            System.out.print(a+" ");
        }
    }
}
