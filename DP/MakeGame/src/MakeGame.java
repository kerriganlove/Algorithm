import java.util.Scanner;

public class MakeGame
{
    public static void main(String[] args)
    {
        int N,M,prx,pry,x,y,dir;
        int answer = 0;
        int count = 0;
        int ending = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        dir = sc.nextInt();
        prx = 5;
        pry = 5;
        int [][]map = new int[N][M];
        for ( int i = 0; i < N*M; i++)
        {
            map[i/M][i%M] = sc.nextInt();
            if (map[i/M][i%M] == 0) { ending++; }
        }

        // Game Rule
        if (map[x][y] == 1)
        {
            System.out.println(answer);
        }
        else
        {
            ++answer;
            while ( count < 5 )
            {
                if (ending == answer)
                {
                    break;
                }
                switch(dir)
                {
                    case 0 :
                        if ( count != 4 ) {
                            if (x-1 > -1 && map[x-1][y] == 0 && prx != x-1)
                                { answer++; prx = x; pry = y; x = x-1; count=0; break;}
                            else { if (count<3) {dir = 3; count++;} break;}
                        }
                        else if ( x+1 < N && count == 4 && map[x+1][y] == 0)
                            { prx = x; pry = y; x = x+1; count=0; break; }
                        else { count++; break;}
                    case 1 :
                        if ( count < 4 ) {
                            if (y+1 < M && map[x][y+1] == 0 && pry != y+1)
                                { answer++; prx = x; pry = y; y = y+1; count=0; break;}
                            else { if (count<3) {dir = 0; count++;} break;}
                            }
                        else if ( y-1 > -1 && count == 4 && map[x][y-1] == 0)
                            { prx = x; pry = y; y = y-1; count=0; break;}
                        else { count++; break;}
                    case 2 :
                        if ( count < 4 ) {
                            if (x+1 < N && map[x+1][y] == 0 && prx != x+1)
                                { answer++; prx = x; pry = y; x = x+1; count=0; break;}
                            else { if (count<3) {dir = 1; count++;} break;}
                        }
                        else if ( x-1 > -1 && count == 4 && map[x-1][y] == 0)
                            { prx = x; pry = y; x = x-1; count=0; break;}
                        else { count++; break;}
                    case 3 :
                        if ( count < 4 ) {
                            if (y-1 > -1 && map[x][y-1] == 0 && pry != y-1)
                                { answer++; prx = x; pry = y; y = y-1; count=0; break;}
                            else { if (count<3) {dir = 2; count++;} break;}
                        }
                        else if ( y+1 < M && count == 4 && map[x][y+1] == 0)
                            { prx = x; pry = y; y = y+1; count=0; break;}
                        else { count++; break;}
                    default : break;
                }
            }
            System.out.println(answer);
        }
    }
}