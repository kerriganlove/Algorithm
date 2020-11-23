import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        BigInteger [] dp = new BigInteger[N.length()+1];
        Arrays.fill(dp,BigInteger.ZERO);
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        if ( N.charAt(0) == '0') { System.out.println(0); }
        else {
            for (int i = 2; i <= N.length(); i++) {
                if (N.charAt(i - 1) > '0') {
                    dp[i] = dp[i].add(dp[i - 1]);
                }
                int twoDigit = (N.charAt(i - 2) - '0') * 10 + (N.charAt(i - 1) - '0');
                if (twoDigit >= 10 && twoDigit <= 26) {
                    dp[i] = dp[i].add(dp[i - 2]);
                }

            }
            System.out.println(dp[N.length()].mod(BigInteger.valueOf(1000000)));
        }
    }
}