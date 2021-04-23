import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while ( T > 0) {
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> hs = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                hs.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                sb.append(hs.contains(Integer.parseInt(st.nextToken())) ? 1 + "\n" : 0 + "\n");
            }
            T--;
        }
        System.out.println(sb.toString());
    }
}
