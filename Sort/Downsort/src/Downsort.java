import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Downsort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N;
        Integer[] arr;
        N = sc.nextInt();
        arr = new Integer[N];
        for ( int i = 0; i < N; i++)
        {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr,Collections.reverseOrder());
        int index = 1;
        for (int i : arr)
        {
            System.out.print(i);
            if ( index < arr.length )
            {
                System.out.print(" ");
                index++;
            }
        }
    }
}
