import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        if ( s.charAt(0) == '0') { System.out.println(-1); }
        char [] list = s.toCharArray();
        Arrays.sort(list);
        for ( int i = 0; i < list.length; i++)
        {
            sum+= list[i] - '0';
        }
        String answer = new StringBuilder(new String(list)).reverse().toString();
        if ( sum % 3 == 0 && answer.charAt(answer.length()-1) == '0')
        {
            System.out.println(answer);
        }
        else
        {
            System.out.println(-1);
        }
    }
}
