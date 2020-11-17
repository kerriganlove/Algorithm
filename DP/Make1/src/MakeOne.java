import java.util.Scanner;

public class MakeOne
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int []DPtable = new int[30001]; // 제한 범위까지
        for (int i = 2; i < X+1; i++) // 2 ~ X까지의 범위 ( 1은 0으로 이미 초기화, i == 입력받은 숫자, DPtable[i] == 숫자에 대한 최소 값 )
        {
            DPtable[i] = DPtable[i - 1] + 1;
            if ( i % 2 == 0) { DPtable[i] = Math.min(DPtable[i],DPtable[i/2] + 1); }
            if ( i % 3 == 0) { DPtable[i] = Math.min(DPtable[i],DPtable[i/3] + 1); }
            if ( i % 5 == 0) { DPtable[i] = Math.min(DPtable[i],DPtable[i/5] + 1); }
         }
        System.out.print(DPtable[X]);
    }
}
