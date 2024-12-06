//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class pair{
    int node;
    int parent;
    pair(int n,int p){
        this.parent=p;
        this.node=n;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(!vis[i]&&detectCycle(vis,adj,i))return true;
        }return false;
    }
    public boolean detectCycle(boolean[]vis,ArrayList<ArrayList<Integer>> adj,int start){
        Stack<pair> st = new Stack<>();
        st.add(new pair(start,-1));
        vis[start]=true;
        while(!st.isEmpty()){
            pair p = st.pop();
            for(int neighbour : adj.get(p.node)){
                if(!vis[neighbour]){
                    vis[neighbour]=true;
                    st.push(new pair(neighbour,p.node));
                }
                else if(neighbour!=p.parent) return true;
            }
        }return false;
    }
}