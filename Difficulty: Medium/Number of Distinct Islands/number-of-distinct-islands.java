//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



class Solution {
    class pair {
        int r;
        int c;

        pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    int countDistinctIslands(int[][] grid) {
        HashSet<List<List<Integer>>> map = new HashSet<>();
        int[] rt = {0, 0, 1, -1};
        int[] ct = {1, -1, 0, 0};
        Stack<pair> st = new Stack<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    List<List<Integer>> ls = new ArrayList<>();
                    st.push(new pair(i, j));
                    vis[i][j] = true;

                    while (!st.isEmpty()) {
                        pair p = st.pop();
                        // Store relative coordinates with respect to the starting point
                        ls.add(new ArrayList<Integer>(Arrays.asList(p.r - i, p.c - j)));
                        for (int x = 0; x < 4; x++) {
                            int r = rt[x] + p.r;
                            int c = ct[x] + p.c;
                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1 && !vis[r][c]) {
                                st.push(new pair(r, c));
                                vis[r][c] = true;
                            }
                        }
                    }

                    // Normalize the shape
                    // System.out.print(Arrays.toString(ls.toArray()));
                    map.add(ls); // Add the normalized shape to the set
                }
            }
        }
        return map.size();
    }
}


