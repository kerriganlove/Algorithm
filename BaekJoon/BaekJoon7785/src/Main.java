import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashSet<String> hs = new HashSet<>();
        for ( int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            String name = st.nextToken();
            String visited = st.nextToken();
            switch(visited){
                case "enter" : hs.add(name); break;
                case "leave" : hs.remove(name); break;
            }
        }
        String[] entry1 = hs.toArray(new String[0]);
        Arrays.sort(entry1,Comparator.reverseOrder());
        for ( String s : entry1)
        {
            System.out.println(s);
        }
    }
}
