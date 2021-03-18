import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        char c = s.charAt(0);
        if(c=='}' || c==']' || c==')')
            return "NO";
        
        Deque<Character> st = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); ++i) {
            c = s.charAt(i);
            if(c=='{' || c=='[' || c=='(') {
                st.push(c);
                continue;
            }
            
            if(!st.isEmpty()) {
                if((c==')' && st.peek()=='(') || 
                (c=='}' && st.peek()=='{') || 
                (c==']' && st.peek()=='['))
                    st.pop();
                else
                    return "NO";
            }   
            
        }   
        
        if(st.isEmpty())
            return "YES";
        else
            return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
