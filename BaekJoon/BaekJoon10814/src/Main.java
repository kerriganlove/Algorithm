import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main
{
    static class Info
    {
        public Info(int num, int age, String name) {
            this.num = num;
            this.age = age;
            this.name = name;
        }

        private int num;
        private int age;
        private String name;
        public int getNum() {
            return num;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Info> arr = new ArrayList<>();
        for ( int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr.add(new Info(i,age,name));
        }
        arr.sort(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                int age1 = o1.age;
                int age2 = o2.age;
                if ( age1 > age2) { return 1; }
                else if ( age1 == age2) { if (o1.num > o2.num) return 1; else return -1; }
                else return -1;
            }
        });
        for ( Info i : arr)
        {
            System.out.println(i.age+" "+i.name);
        }
    }
}