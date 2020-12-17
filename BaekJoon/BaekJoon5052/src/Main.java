import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String [] answers = new String[T];
        for ( int i = 0; i < T; i++)
        {
            int N = Integer.parseInt(br.readLine());
            boolean answer = false;
            String []s = new String[N];
            Trie trie = new Trie();
            for ( int j = 0; j < N; j++)
            {
                s[j] = br.readLine();
                trie.insert(s[j]);
            }
            for ( String st : s) {
                answer = trie.isOK(st);
                if (!answer) {
                    break;
                }
            }
            answers[i] = answer ? "YES" : "NO";
        }
        for (String s : answers)
        {
            System.out.println(s);
        }
    }
    static class TrieNode
    {
        public void setLast(boolean last) {
            isLast = last;
        }

        public Map<Character, TrieNode> getChildNode() {
            return childNode;
        }

        public boolean isLast() {
            return isLast;
        }

        private Map<Character, TrieNode> childNode= new HashMap<>();
        private boolean isLast;
    }
    static class Trie
    {
        public Trie() {
            rootNode = new TrieNode();
        }

        private TrieNode rootNode;
        void insert(String word)
        {
            TrieNode thisNode = this.rootNode;
            for ( int i = 0; i < word.length(); i++)
            {
                thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i),c->new TrieNode());
            }
            thisNode.setLast(true);
        }
        boolean find(String word)
        {
            TrieNode thisNode = this.rootNode;
            for ( int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);
                TrieNode node = thisNode.getChildNode().get(i);
                if ( node == null) { return false; }

                thisNode = node;
            }
            return thisNode.isLast();
        }
        boolean isOK(String word)
        {
            TrieNode thisNode = this.rootNode;
            for ( int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);
                if (thisNode.isLast())
                {
                    return false;
                }
                thisNode = thisNode.getChildNode().get(c);
            }
            return true;
        }
    }
}
