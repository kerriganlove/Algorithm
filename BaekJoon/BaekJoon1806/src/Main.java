import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    static int N;
    static int M;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String s2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s2," ");
        list = new ArrayList<Integer>();
        while(st2.hasMoreTokens())
        {
            list.add(Integer.parseInt(st2.nextToken()));
        }
        System.out.println(TwoPointers());
    }
    public static int TwoPointers()
    {
        int start = 0;
        int end = 0;
        int sum = list.get(0);
        int answer = list.size()+1;

        while(true)
        {
            if (sum >= M) { answer = Math.min(answer,(end-start)+1); sum-= list.get(start++);}
            else if ( sum < M ) { if ( end == list.size()-1 ) { end++; } else {sum+= list.get(++end);} }

            if( end == list.size() || start == list.size() ) { break; }
        }
        if ( answer == list.size()+1) { answer = 0; }
        return answer;
    }
}

