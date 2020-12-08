public class Main
{
    public static void main(String[] args)
    {
        boolean [] answer = new boolean[10001];
        for ( int i = 1; i < 10001; i++)
        {
            int a = selfNum(i);
            if ( a <= 10000) {
                answer[a] = true;
            }
        }
        for ( int i = 1; i < 10001; i++)
        {
            if (answer[i] == false)
            {
                System.out.println(i);
            }
        }
    }
    public static int selfNum(int num)
    {
        int n = num;
        while (num != 0)
        {
            n += (num%10);
            num = num/10;
        }
        return n;
    }
}
