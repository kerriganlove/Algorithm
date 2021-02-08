import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = 0;
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] list = new int[K];
        for ( int i = 0; i < K; i++)
        {
            int c = Integer.parseInt(st.nextToken());
            list[i] = c;
        }
        boolean [] tabs = new boolean[K+1];
        for ( int i = 0; i < K; i++)
        {
            int num = list[i];
            int max = 0;
            if ( number != N && !tabs[num] )
            {
                tabs[num] = true;
                number++;
            }
            else if ( number == N && !tabs[num])
            {
                int s = 0;
                HashMap<Integer, Integer> hm = new HashMap<>();
                for ( int j = 1; j <= K; j++)
                {
                    if (tabs[j])
                    {
                        for ( int k = i+1; k < K; k++) {
                            if ( j == list[k]) { max = Math.max(max,k); break;}
                        }
                        if ( max == 0) { max = K+1; }
                        hm.put(j,max);
                        max = 0;
                    }
                }
                List<Integer> keyList = new ArrayList<>(hm.keySet());
                Collections.sort(keyList, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return hm.get(o2).compareTo(hm.get(o1));
                    }
                });
                tabs[keyList.get(0)] = false;
                tabs[num] = true;
                answer++;
            }
        }
        System.out.println(answer);
    }
}

