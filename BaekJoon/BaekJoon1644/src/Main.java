import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        boolean []list = new boolean[N+1];
        ArrayList<Integer> addList = new ArrayList<Integer>();
        for ( int i = 2; i*i < N+1; i++)
        {
            if ( list[i] ) continue;
            for ( int j = i*i; j < N+1; j+=i)
            {
                if (!list[j]) { list[j] = true; }
            }
        } // 소수 판별 코드 boolean으로 함
        for (int k = 2; k < N+1; k++)
        {
            if(!list[k]) { addList.add(k); }
        }// 문제가 이거일수도 있겠다는 생각을 해봄. 근데 이거 말고는 방법이 없음.
        int start = 0;
        int end = 0;
        int sum = 0;
        while (true)
        {
            if ( sum >= N) { sum -= addList.get(start++); }
            else if ( end == addList.size()) { break; }
            else if ( sum < N) { sum += addList.get(end++); }

            if ( sum == N ) { cnt++;}
        }
        System.out.print(cnt);
    }
}
