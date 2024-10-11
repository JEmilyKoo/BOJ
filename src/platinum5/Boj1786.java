package platinum5;
import java.io.*;
import java.util.*;

public class Boj1786 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(new File("./res/input1786.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();  
        String P = br.readLine();  

        int[] pi = getPartialMatch(P);

        int result = 0;
        List<Integer> cntList = new ArrayList<>();

        int n = T.length();
        int m = P.length();
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }

            if (T.charAt(i) == P.charAt(j)) {
                if (j == m - 1) {
                    result++;
                    cntList.add(i - m + 2);
                    j = pi[j]; 
                } else {
                    j++;
                }
            }
        }

        System.out.println(result);
        for (int index : cntList) {
            System.out.print(index + " ");
        }
        br.close();
    }

    private static int[] getPartialMatch(String P) {
        int m = P.length();
        int[] pi = new int[m];
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }

            if (P.charAt(i) == P.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
