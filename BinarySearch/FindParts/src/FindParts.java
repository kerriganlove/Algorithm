import java.util.Arrays;
import java.util.Scanner;

public class FindParts
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N,M;
        N = sc.nextInt();
        int count = 0;
        int []list = new int[N];
        for (int i = 0; i < N; i++)
        {
            list[i] = sc.nextInt();
        }
        Arrays.sort(list);
        M = sc.nextInt();
        int []find = new int[M];
        for ( int j = 0; j < M; j++)
        {
            find[j] = sc.nextInt();
        }
        for (int parts : find)
        {
            System.out.print(binary_search(list,parts,0,N-1));
            count++;
            if ( count < M) { System.out.print(" "); }
        }
    }
    public static String binary_search(int[] array, int target, int start, int end)
    {
        if (start > end) { return "No"; }

        int middle = (start+end) / 2;
        if ( array[middle] > target )
        {
           return binary_search(array, target, start, middle-1);
        }
        else if (array[middle] < target) { return binary_search(array,target, middle+1, end); }
        else if ( array[middle] == target) { return "Yes" ;}

        return "Trash Parts";
    }
}
