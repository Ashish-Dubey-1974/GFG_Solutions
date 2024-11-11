//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int k, int[] arr) {
        // code here
        int floor=Integer.MIN_VALUE,ceil=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==k)return new int[]{arr[i],arr[i]};
            if(arr[i]>k&&ceil>arr[i])ceil=arr[i];
            if(arr[i]<k&&arr[i]>floor)floor=arr[i];
        }if(floor==Integer.MIN_VALUE)floor=-1;
        if(ceil==Integer.MAX_VALUE )ceil=-1;
        return new int[]{floor,ceil};
    }
}
