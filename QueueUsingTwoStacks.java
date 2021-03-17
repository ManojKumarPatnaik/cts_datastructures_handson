import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new ArrayDeque<>();
        int n = sc.nextInt();
        
        while(n!=0) {
            --n;
            int first = sc.nextInt();
            
            if(first==1) {
                int sec = sc.nextInt();
                dq.add(sec);
            }
            else if(first==2) {
                    dq.poll();
            }
            else {
                System.out.println(dq.peek());
            }
        }
    }
}
