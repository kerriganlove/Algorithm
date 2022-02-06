import java.io.*;
import java.util.*;
public class Main
{
    static int x,y,z;
    static int [] lines;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            lines = new int[3];
            lines[0] = Integer.parseInt(st.nextToken());
            lines[1] = Integer.parseInt(st.nextToken());
            lines[2] = Integer.parseInt(st.nextToken());
            if ( lines[0] == 0 && lines[1] == 0 && lines[2] == 0)
            {
                break;
            }
            Arrays.sort(lines);
            if ( lines[0] + lines[1] <= lines[2])
            {
                bw.write("Invalid\n");
                continue;
            }
            if (lines[0] == lines[1])
            {
                if ( lines[1] == lines[2])
                {
                    bw.write("Equilateral\n");
                }
                else
                {
                    bw.write("Isosceles\n");
                }
            }
            else
            {
                if (lines[0] == lines[2] || lines[1] == lines[2])
                {
                    bw.write("Isosceles\n");
                }
                else
                {
                    bw.write("Scalene\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
