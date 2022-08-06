package geeks.select_nodes;

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int[][]edge=new int[N-1][2];
            for(int i=0;i<N-1;i++)
            {
                String input[] = read.readLine().trim().split("\\s+");
                edge[i][0]=Integer.parseInt(input[0]);
                edge[i][1]=Integer.parseInt(input[1]);
            }
            Solution ob = new Solution();
            System.out.println(ob.countVertex(N, edge));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{

    static class Node{
        ArrayList<Node> children;
        int key;

        public Node(int key){
            this.key = key;
            this.children = new ArrayList<>();
        }

        public Node addChild(int childKey){
            Node child = new Node(childKey);
            this.children.add(child);

            return child;
        }
    }

    private int count=0;
    public int countVertex(int N, int[][] edges){
        // code here
        HashSet<Integer> roots = new HashSet<>();
        HashSet<Integer> childs = new HashSet<>();

        HashMap<Integer,Node> nodes = new HashMap<>();

        for(int i=0; i < edges.length; i++){
            int[] edge = edges[i];

            if(!childs.contains(edge[0])){
                roots.add(edge[0]);
            }
            else{
                roots.remove(edge[0]);
            }

            childs.add(edge[1]);

            if(!nodes.containsKey(edge[0])){
                nodes.put(edge[0], new Node(edge[0]));
            }

            Node child = nodes.get(edge[0]).addChild(edge[1]);
            nodes.put(edge[1], child);
        }

        Node root = nodes.get(roots.iterator().next());


        traverse(root);

        return count;

    }

    public boolean traverse(Node root){
        if(root.children.size() == 0) return false;

        boolean result = true;
        for(int i=0; i < root.children.size(); i++){
            result = traverse(root.children.get(i)) && result;
        }

        if(!result == true) count++;
        return !result;
    }
}

// { Driver Code Starts.
// } Driver Code Ends