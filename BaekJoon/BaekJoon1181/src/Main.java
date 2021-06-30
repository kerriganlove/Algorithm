import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class Main
{
    public static class Word implements Comparable<Word>
    {
        int len;
        String word;

        public Word(int len, String word) {
            this.len = len;
            this.word = word;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word1 = (Word) o;
            return (this.len == word1.len &&
                    Objects.equals(this.word, word1.word));
        }

        @Override
        public int hashCode() {
            return (len+word).hashCode();
        }

        @Override
        public int compareTo(Word o) {
            if ( this.len > o.len) { return 1; }
            else if ( this.len == o.len)
            {
                return this.word.compareTo(o.word);
            }
            return -1;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashSet<Word> trset = new HashSet<>();
        String str;
        for ( int i = 0; i < N; i++)
        {
            str = br.readLine();
            trset.add(new Word(str.length(), str));
        }
        ArrayList<Word> list = new ArrayList<>(trset);
        Collections.sort(list);
        for ( Word w : list)
        {
            bw.write(w.word+"\n");
        }
        bw.flush();
        bw.close();
    }
}
