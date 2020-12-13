import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int [] answer = new int[T];
        for ( int i = 0; i < T; i++)
        {
            answer[i] = hailStone(Integer.parseInt(br.readLine()));
        }
        for (int i : answer)
        {
            System.out.println(i);
        }
    }
    public static int hailStone(int num)
    {
        int max = num;
        while(num != 1)
        {
            switch(num%2)
            {
                case 0: num = num/2; break;
                case 1: num = num*3 + 1; break;
            }
            max = Math.max(num,max);
        }
        return max;
    }
}
