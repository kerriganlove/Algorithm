import java.io.*;
import java.util.Scanner;

public class Main
{
    static class Node
    {
        int value;
        Node left;
        Node right;
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    static class BST
    {
        Node rootNode = null;
        public void lastOrder(Node root, int depth)
        {
            if ( root!= null) {
                lastOrder(root.left, depth + 1);
                lastOrder(root.right, depth + 1);
                System.out.println(root.value);
            }
        }
        public void insert(int m)
        {
            if ( rootNode == null) { rootNode = new Node(m,null,null); }
            else
            {
                Node head = rootNode;
                Node currentNode;
                while(true)
                {
                    currentNode = head;
                    if ( head.value > m )
                    {
                        head = head.left;
                        if ( head == null)
                        {
                            currentNode.left = new Node(m,null,null);
                            break;
                        }
                    }
                    else
                    {
                        head = head.right;
                        if ( head == null ) { currentNode.right = new Node(m,null,null); break;}
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BST tree = new BST();
        String a;
        while((a = br.readLine()) != null)
        {
            tree.insert(Integer.parseInt(a));
        }
        tree.lastOrder(tree.rootNode,0);
    }
}
