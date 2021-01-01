import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String eight = br.readLine();
        int len = eight.length();
        StringBuilder sb = new StringBuilder();
        for ( int i = len-1; i >= 0; i--)
        {
            sb.append(new StringBuilder(changeTwo(eight.charAt(i),i)).reverse());
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
    static String changeTwo(char c, int cnt)
    {
        String num = "";
        if ( cnt != 0)
        {
            switch(c)
            {
                case '0' : num = "000"; break;
                case '1' : num = "001"; break;
                case '2' : num = "010"; break;
                case '3' : num = "011"; break;
                case '4' : num = "100"; break;
                case '5' : num = "101"; break;
                case '6' : num = "110"; break;
                case '7' : num = "111"; break;
            }
        }
        else {
            switch(c)
            {
                case '0' : num = "0"; break;
                case '1' : num = "1"; break;
                case '2' : num = "10";break;
                case '3' : num = "11"; break;
                case '4' : num = "100"; break;
                case '5' : num = "101"; break;
                case '6' : num = "110"; break;
                case '7' : num = "111"; break;
            }
        }
        return num;
    }
}
