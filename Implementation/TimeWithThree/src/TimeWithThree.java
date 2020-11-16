import java.util.Scanner;

public class TimeWithThree
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        for ( int i = 0; i <=N; i++)
        {
            if ( i == 3 || i == 13 || i == 23)
            {
                answer += 3600; // 0000 ~ 5959까지 나타날 수 있는 모든 경우의 수(왜냐하면 앞에서 3이 한번이라도 포함됬기 때문)
            }
            else
            {
                answer += 1575; // 0000 ~ 5959까지 중 3이 1번이라도 포함된 경우의 수
            }
        }
        System.out.println(answer);
    }
}
