import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main
{
    static boolean []visited = new boolean[26];
    static char pre;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for ( int i = 0; i < N; i++)
        {
            sum+=Search(br.readLine());
        }
        System.out.println(sum);
    }
    public static int Search(String s)
    {
        for ( int i = 0; i < s.length(); i++)
        {
            int loc = s.charAt(i) - 'a';
            if (visited[loc] == false)
            {
                visited[loc] = true;
                pre = s.charAt(i);
            }
            else{
                if ( pre!= s.charAt(i))
                {
                    Arrays.fill(visited,false);
                    pre = ' ';
                    return 0;
                }
            }
        }
        Arrays.fill(visited,false);
        pre = ' ';
        return 1;
    }
}
