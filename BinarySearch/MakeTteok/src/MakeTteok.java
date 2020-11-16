import java.util.Arrays;
import java.util.Scanner;

public class MakeTteok
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N,M;
        int start = 0;
        int end;
        int total;
        int middle = 0;
        N = sc.nextInt();
        M = sc.nextInt();
        int []tteokList = new int[N];
        for ( int i = 0; i < N; i++ )
        {
            tteokList[i] = sc.nextInt();
        }
        Arrays.sort(tteokList);
        end = tteokList[N-1];
        while ( start <= end )
        {
            total = 0;
            middle = (start + end) / 2;
            for ( int len : tteokList )
            {
                if ( len > middle )
                {
                    total += len - middle;
                }
            }
            if ( total > M )
            {
                start = middle+1;
            }
            else if ( total < M )
            {
                end = middle - 1;
            }
            else if ( total == M ){ break; };
        }
        System.out.print(middle);
    } // Parametric search : 최적화 문제 => 결정 문제로 바꾸는 것.
      // 원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제
}
