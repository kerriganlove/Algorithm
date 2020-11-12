import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LGFN
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[][] list = new String[N][2];
        for (String str[] : list)
        {
            str[0] = sc.next();
            str[1] = sc.next();
        }
        Arrays.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
        });
        int index = 1;
        for (String str[] : list)
        {
            System.out.print(str[0]);
            if (index < N)
            {
                System.out.print(" ");
                index++;
            }
        }
    }
}
