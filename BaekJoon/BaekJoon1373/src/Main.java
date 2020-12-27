import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int num = 0;
        for ( int i = s.length()-1; i >= 0; i--)
        {
            if ( s.charAt(i) == '0') { num+= 0; }
            else if ( s.charAt(i) == '1') { num+= (int)Math.pow(2,cnt); }
            cnt++;
            if ( cnt == 3) { sb.append(num); num = 0; cnt = 0;}
            else if ( i == 0 && cnt != 3) { sb.append(num); }
        }
        System.out.println(sb.reverse().toString());
    }
}
