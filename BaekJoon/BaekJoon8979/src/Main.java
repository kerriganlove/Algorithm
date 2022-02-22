import java.io.*;
import java.util.*;

public class Main
{
    static class Info implements Comparable<Info>
    {
        int cont;
        int gold;
        int silver;
        int bronze;
        public Info(int cont, int gold, int silver, int bronze)
        {
            this.cont = cont;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
        @Override
        public int compareTo(Info in)
        {
            if ( this.gold == in.gold)
            {
                if ( this.silver == in.silver)
                {
                    return in.bronze - this.bronze;
                }
                return in.silver - this.silver;
            }
            return in.gold - this.gold;
        }
    }
    static ArrayList<Info> list;
    static int [] grade;
    public static void main(String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        grade = new int[n+1];
        for ( int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int cont = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Info(cont, gold, silver, bronze));
        }
        for ( int i = 0; i < list.size(); i++)
        {
            for ( int j = 0; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    grade[list.get(i).cont]++;
                }
            }
        }
        bw.write((grade[k]+1)+"\n");
        bw.flush();
        bw.close();
    }
}
