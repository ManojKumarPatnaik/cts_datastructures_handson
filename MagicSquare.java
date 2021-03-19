import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int b0[][] = { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } };
        int b1[][] = { { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } };
        int b2[][] = { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } };
        int b3[][] = { { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } };
        int b4[][] = { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } };
        int b5[][] = { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } };
        int b6[][] = { { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } };
        int b7[][] = { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } };
        int[] costArray = new int[8];
        costArray[0] = costFunc(s, b0);
        costArray[1] = costFunc(s, b1);
        costArray[2] = costFunc(s, b2);
        costArray[3] = costFunc(s, b3);
        costArray[4] = costFunc(s, b4);
        costArray[5] = costFunc(s, b5);
        costArray[6] = costFunc(s, b6);
        costArray[7] = costFunc(s, b7);
        Arrays.sort(costArray);
        return costArray[0];

    }

    public static int costFunc(int s[][], int b[][]) {
        int cost = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cost += (int) Math.abs(s[i][j] - b[i][j]);
            }
        }
        return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
