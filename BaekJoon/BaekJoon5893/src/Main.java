import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        BigInteger i = new BigInteger(s,2);
        BigInteger answer = i.multiply(BigInteger.valueOf(17));

        System.out.println(answer.toString(2));
    }

}
