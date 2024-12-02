//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int count=0;
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                dfs(vis,adj,i);
                count++;
            }
        }return count;
    }
    static void dfs(boolean[] vis,ArrayList<ArrayList<Integer>> adj,int idx){
        Stack<Integer> st = new Stack<>();
        st.push(idx);
        vis[idx]=true;
        while(!st.isEmpty()){
            int node = st.pop();
            for(int it=0;it<adj.get(idx).size();it++){
                if(adj.get(node).get(it)==1&&vis[it]==false){
                    st.push(it);
                    vis[it]=true;
                }
            }
        }
        
    }
};