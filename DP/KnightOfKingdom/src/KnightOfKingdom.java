import java.util.Scanner;

public class KnightOfKingdom
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String locate = sc.nextLine();
        int count = 0;
        char x = locate.charAt(0);
        int y = locate.charAt(1) - 48; // 아스키코드 활용 문자->숫자 변환
        int chx = x - 96; // 아스키코드 활용 위치 열과 같이 int형 변환

        int []answer = {chx,y};
        int [][]cons = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
        for (int i = 0; i < 8; i++)
        {
            if(answer[0] + cons[i][0] > 0 && answer[1] + cons[i][1] > 0)
            {
                count++;
            }
        }
        System.out.println(count);

    }
}
