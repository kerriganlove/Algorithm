import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        BigDecimal num = new BigDecimal(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        bw.write(num.pow(e).toPlainString()+"\n");
        bw.flush();
        bw.close();
    }
}
