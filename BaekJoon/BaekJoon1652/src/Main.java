import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] arr = new String[N];
        for ( int i = 0; i < N; i++)
        {
            arr[i] = br.readLine();
        }
        int width = 0;
        int height = 0;
        for ( int i = 0; i < N; i++)
        {
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < N; j++)
            {
                switch(arr[i].charAt(j))
                {
                    case '.' : count1++; break;
                    case 'X' : if ( count1 > 1) { width++; } count1 = 0; break;
                }
                switch(arr[j].charAt(i))
                {
                    case '.' : count2++; break;
                    case 'X' : if (count2 > 1) { height++; } count2 = 0; break;
                }
            }
            if ( count1 > 1 ) { width++; }
            if ( count2 > 1) { height++; }
        }
        System.out.println(width+" "+height);
    }
}
