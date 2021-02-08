import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class On
    {
        boolean b;
        int pre;
        public On(boolean b, int pre) {
            this.b = b;
            this.pre = pre;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int [] list = new int[num];
        int [] like = new int[101];
        ArrayList<On> on = new ArrayList<>();
        for ( int i = 0; i < 101; i++)
        {
            on.add(new On(false,0));
        }
        for ( int i = 0; i < num; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        for ( int i = 0; i < num; i++)
        {
            int rec = list[i];
            HashMap<Integer, Integer> hm = new HashMap<>();
            if ( count != N && !on.get(rec).b) { count++; on.get(rec).b = true; on.get(rec).pre = i+1; like[rec]++;}
            else if ( count == N && !on.get(rec).b)
            {
                for ( int j = 1; j < 101; j++)
                {
                    if ( on.get(j).b ) { hm.put(j,like[j]); }
                }
                List<Integer> keyList = new ArrayList<>(hm.keySet());
                Collections.sort(keyList, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if ( hm.get(o1) == hm.get(o2))
                        {
                            return Integer.compare(on.get(o1).pre,on.get(o2).pre);
                        }
                        else { return hm.get(o1).compareTo(hm.get(o2)); }
                    }
                });
                on.get(keyList.get(0)).b = false;
                on.get(keyList.get(0)).pre = 0;
                on.get(rec).b = true;
                on.get(rec).pre = i+1;
                like[rec]++;
                like[keyList.get(0)] = 0;
            }
            else if ( on.get(rec).b) { like[rec]++; }
        }
        for ( int i = 1; i < 101; i++)
        {
            if ( on.get(i).b == true) { sb.append(i+" "); }
        }
        System.out.println(sb.toString());
    }
}
