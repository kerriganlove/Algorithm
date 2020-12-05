import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String []answer = new String[N];
        for ( int i = 0; i < N; i++)
        {
            String s = br.readLine();
            if (( s.charAt(s.length()-1)-'0') % 2 == 1)
            {
                answer[i] = "odd";
            }
            else { answer[i] = "even"; }
        }
        for (String st : answer)
        {
            System.out.println(st);
        }
    }
}
