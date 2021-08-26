import java.io.*;
import java.util.*;

public class Main
{
    public static class Heap
    {
        static ArrayList<Integer> heap;
        public Heap()
        {
            heap = new ArrayList<>();
            heap.add(0);
        }
        public static void insert(int num)
        {
            heap.add(num);
            int size = heap.size()-1;
            while(size > 1 && Math.abs(heap.get(size/2)) >= Math.abs(heap.get(size)))
            {
                int tmp = heap.get(size/2);
                if ( Math.abs(heap.get(size)) == Math.abs(tmp))
                {
                    if ( tmp > num)
                    {
                        heap.set(size/2,num);
                        heap.set(size,tmp);
                    }
                }
                else {
                    heap.set(size/2, num);
                    heap.set(size, tmp);
                }
                size /= 2;
            }
        }
        static int delete()
        {
            int delete = 0;
            if ( heap.size()-1 < 1) {
                return 0;
            }
            else
            {
                delete = heap.get(1);
                heap.set(1,heap.get(heap.size()-1));
                heap.remove(heap.size()-1);
                int pos = 1;
                while(pos*2 < heap.size())
                {
                    int min = heap.get(pos*2);
                    int minPos = pos*2;
                    if ( pos*2+1 < heap.size() && Math.abs(min) >= Math.abs(heap.get(pos*2+1)))
                    {
                        if (Math.abs(min) == Math.abs(heap.get(pos*2+1)))
                        {
                            if (min > heap.get(pos*2+1))
                            {
                                min = heap.get(pos*2+1);
                                minPos = pos*2+1;
                            }
                        }
                        else {
                            min = heap.get(pos * 2 + 1);
                            minPos = pos * 2 + 1;
                        }
                    }
                    if ( Math.abs(min) >= Math.abs(heap.get(pos)))
                    {
                        if ( Math.abs(min) == Math.abs(heap.get(pos)))
                        {
                            if ( min > heap.get(pos))
                            {
                                break;
                            }
                        }
                        else
                        {
                            break;
                        }
                    }
                    int tmp = heap.get(pos);
                    heap.set(pos, heap.get(minPos));
                    heap.set(minPos, tmp);
                    pos = minPos;
                }
                return delete;
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Heap h = new Heap();
        for ( int i = 0; i < N; i++)
        {
            int num = Integer.parseInt(br.readLine());
            if ( num == 0) { bw.write(h.delete()+"\n"); }
            else { h.insert(num); }
        }
        bw.flush();
        bw.close();
    }
}
