import java.io.*;
import java.util.*;

public class Main
{
    static ArrayList<ArrayList<Integer>> node;
    static class Info implements Comparable<Info>
    {
        int val;
        int sum;
        public Info(int val, int sum)
        {
            this.val = val;
            this.sum = sum;
        }
        @Override
        public int compareTo(Info in)
        {
            return this.sum - in.sum;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while ( t > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            ArrayList<Integer> al = new ArrayList<>();
            int [] list = new int[n+1];
            int [] dp = new int[201];
            node = new ArrayList<>();
            for ( int i = 0; i <= 200; i++)
            {
                node.add(new ArrayList<>());
            }
            for ( int i = 1; i <= n; i++)
            {
                int grade = Integer.parseInt(st.nextToken());
                list[i] = grade;
                dp[grade]++;
            }
            for ( int i = 1; i <= n; i++)
            {
                if ( dp[list[i]] == 6)
                {
                    al.add(list[i]);
                }
            }
            for ( int i = 0; i < al.size(); i++)
            {
                node.get(al.get(i)).add(i+1);
            }
            ArrayList<Info> sumList = new ArrayList<>();
            for ( int i = 1; i < node.size(); i++)
            {
                if ( node.get(i).size() != 0)
                {
                    int s_sum = 0;
                    for ( int j = 0; j < 4; j++)
                    {
                        s_sum += node.get(i).get(j);
                    }
                    sumList.add(new Info(i,s_sum));
                }
            }
            Collections.sort(sumList);
            int answer = sumList.get(0).val;
            int min = sumList.get(0).sum;
            for ( int i = 1; i < sumList.size(); i++)
            {
                int val = sumList.get(i).val;
                int sum = sumList.get(i).sum;
                if ( min == sum) {
                    if (node.get(answer).get(4) > node.get(val).get(4))
                    {
                        answer = val;
                    }
                }
                else
                {
                    break;
                }
            }
            sb.append(answer+"\n");
            t--;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
