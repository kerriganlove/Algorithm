import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < N; i++)
        {
            String s = br.readLine();
            char c = Character.toUpperCase(s.charAt(0));
            sb.append(c+s.substring(1)+"\n");
        }
        System.out.print(sb.toString());
    }
}
