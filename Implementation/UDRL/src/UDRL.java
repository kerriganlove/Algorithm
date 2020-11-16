import java.util.Scanner;

public class UDRL
{
    public static void main(String[] args)
    {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int x = 1;
        int y = 1;
        int N = sc1.nextInt();
        String M;
        M = sc2.nextLine();
        String []moving = M.split(" ");
        for (int i = 0; i < moving.length && i < 100; i++) {
            switch (moving[i]) {
                case "L":
                    if (y == 1) { y = 1; }
                    else { --y; }
                    break;
                case "R":
                    if (y == N) { y = N; }
                    else { ++y; }
                    break;
                case "U":
                    if (x == 1) { x = 1; }
                    else { --x; }
                    break;
                case "D":
                    if (x == N) { x = N; }
                    else { ++x;}
                    break;
                default:
                    break;
            }
        }
        System.out.println(x+" "+y);
    }
}
