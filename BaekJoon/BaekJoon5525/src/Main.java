import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    static int[] pi;
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        pi = new int[(2*N)+1];
        int answer = 0;
        String st = bf.readLine();
        StringBuilder result = new StringBuilder();
        for ( int i = 0; i < 2*N+1; i++)
        {
            if (i % 2 == 0) { result.append("I"); }
            else if ( i % 2 == 1) { result.append("O"); }
        }
        makePi(result.toString());
        System.out.println(KMP(st,result.toString()));
    }
    public static void makePi(String str)
    {
        int len = str.length();
        int j = 0;
        for ( int i = 1; i < len; i++)
        {
            while(j > 0 && str.charAt(i) != str.charAt(j)) { j = pi[i-1]; }
            if ( str.charAt(i) == str.charAt(j)) { pi[i] = ++j; }
        }
    }
    public static int KMP(String org, String part)
    {
        int count = 0;
        int j = 0;
        for ( int i = 0; i < org.length(); i++ )
        {
            while(j > 0 && org.charAt(i) != part.charAt(j)) { j = pi[j-1]; }
            if (org.charAt(i) == part.charAt(j))
            {
                if (j == part.length()-1) { j = pi[j]; count++; }
                else { j++; }
            }
        }
        return count;
    }
}
