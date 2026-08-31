public class Shortest_Palindrome {
    public String shortestpalindrome(String s){
        String rev=new StringBuilder(s).reverse().toString();
        String str=s+"#"+rev;
        int[] lps=calculateLPS(str);
        int longestPrefix=lps[str.length()-1];
        String remaining=s.substring(longestPrefix);
        String add=new StringBuilder(remaining).reverse().toString();
        return add+s;
    }

    private int[] calculateLPS(String s) {
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
        return lps;
    }
}
