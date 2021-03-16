import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        int st = Integer.parseInt(s.substring(0,2)), len = s.length();
        String lst = s.substring(len-2);
        
        if(st==12) {
            if(lst.equalsIgnoreCase("AM"))
                return "00"+s.substring(2,len-2);
            else
                return s.substring(0,len-2);
        } 
        else if(lst.equalsIgnoreCase("PM")){
            return (st+12)+s.substring(2,len-2);
        } 
        else {
            return "0"+st+s.substring(2,len-2);
        }
        
        
            
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
