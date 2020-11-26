import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main
{
    public static void main(String[] args) throws IOException {
        HashMap<String,String> hm = new HashMap<String, String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String name,number;
        String answer;
        for (int i = 0; i < N; i++) {
            name = br.readLine();
            number = Integer.toString(i+1);
            hm.put(name,number);
            hm.put(number,name);
        }
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < M; i++)
        {
            answer = br.readLine();
            sb.append(hm.get(answer)+"\n");
        }
        System.out.println(sb.toString());
    }

}
