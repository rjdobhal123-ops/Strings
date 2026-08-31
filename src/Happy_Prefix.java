import java.util.Arrays;

public class Happy_Prefix {
    public static String longestPrefix(String s) {
        int n=s.length();
        // Build LPS array for needle
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i] = len + 1;
                len++;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return s.substring(0,lps[n-1]);
    }

    public static void main(String[] args) {
        System.out.println(longestPrefix("ababab"));
    }
}
