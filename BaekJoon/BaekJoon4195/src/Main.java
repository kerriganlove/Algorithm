import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main
{
    static int MAX = 200010;
    static int [] parents = new int[MAX];
    static int [] size = new int[MAX];
    static int find(int value)
    {
        if ( value == parents[value])
        {
            return value;
        }
        parents[value] = find(parents[value]);
        return parents[value];
    }
    static void union(int value1, int value2)
    {
        value1 = find(value1);
        value2 = find(value2);
        if ( value1 != value2)
        {
            if ( size[value1] != size[value2])
            {
                int temp = size[value1];
                size[value1] = size[value2];
                size[value2] = temp;
            }
            parents[value2] = value1;
            size[value1] += size[value2];
            size[value2] = 0;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while ( T > 0)
        {
            int F = Integer.parseInt(br.readLine());
            for ( int i = 0; i < MAX; i++)
            {
                parents[i] = i;
                size[i] = 1;
            }
            StringTokenizer st;
            Map<String,Integer> map = new HashMap<>();
            int idx = 1;
            for ( int i = 0; i < F; i++)
            {
                st = new StringTokenizer(br.readLine()," ");
                String name1 = st.nextToken();
                String name2 = st.nextToken();
                if (map.get(name1) == null)
                {
                    map.put(name1,idx++);
                }
                if (map.get(name2) == null)
                {
                    map.put(name2,idx++);
                }
                int par1 = find(map.get(name1));
                int par2 = find(map.get(name2));
                if ( par1 == par2)
                {
                    bw.write(Math.max(size[par1],size[par2])+"\n");
                }
                else
                {
                    union(par1, par2);
                    bw.write(Math.max(size[par1], size[par2])+"\n");
                }
            }
            T--;
        }
        bw.flush();
        bw.close();
    }
}
