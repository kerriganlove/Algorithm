import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s,"-");
        int temp;
        int answer = 0;
        int count = 0;
        while(st.hasMoreTokens())
        {
            temp = 0;
            StringTokenizer st2 = new StringTokenizer(st.nextToken(),"+");
            while(st2.hasMoreTokens())
            {
                temp+=Integer.parseInt(st2.nextToken());
            }
            if ( count == 0 ) { answer+= temp; }
            else { answer-= temp; }
            count++;
        }
        System.out.println(answer);
    }
}
